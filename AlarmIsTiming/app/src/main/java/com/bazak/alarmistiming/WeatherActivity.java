package com.bazak.alarmistiming;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.Image;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class WeatherActivity extends AppCompatActivity {

    //xml parsing에 관련된변수
    TextView txtWeatherTitle, txtWeather1, txtWeather2, txtWeather3, txtWeather4;
    StringBuffer buffer;
    int i;
    String location, result1, result2, result3, result4;

    //location manager에 관련된 변수
    LocationManager locationManager;

    String provider;
    double latitude, longitude;
    String locationCode = ""; //1174064000
    String locationStr;
    WifiManager wifiManager;
    String descArr[] = new String[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        txtWeatherTitle = (TextView) findViewById(R.id.txt_weather_title);
        txtWeather1 = (TextView) findViewById(R.id.txt_weather_1);
        txtWeather2 = (TextView) findViewById(R.id.txt_weather_2);
        txtWeather3 = (TextView) findViewById(R.id.txt_weather_3);
        txtWeather4 = (TextView) findViewById(R.id.txt_weather_4);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);

        mGetLocation();
    }

    public void mGetLocation(){
        if (!wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(true); //와이파이 킴
        }

        provider = LocationManager.NETWORK_PROVIDER;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        //네트워크가 위치를 받아옴
        Location location = locationManager.getLastKnownLocation(provider);

        if (location != null) { //받아온 경우
            latitude = location.getLatitude(); //위도
            longitude = location.getLongitude(); //경도
        }

        Log.i("MyTag", latitude + " , " + longitude);

        try {
            locationManager.requestLocationUpdates(provider, 1, 1, locationListener);

            //위도,경도 -> 주소
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());

            List<Address> addressList = geocoder.getFromLocation(latitude, longitude,1);
            if(addressList == null || addressList.size()==0){ //받아온 정보가 없는 경우
                Toast.makeText(this, "위치를 받아올 수 없습니다", Toast.LENGTH_SHORT).show();
            }

            locationStr = addressList.get(0).getAddressLine(0); //서울특별시 강동구 ~~~ 뽑아옴
            Log.i("MyTag", "locationStr : "+ locationStr);

            //받아온 주소와 키값을 비교
            AddressCode ac = new AddressCode();
            Set<String> keys = ac.getKeyName();

            locationStr = locationStr.replace("대한민국", "");
            locationStr = locationStr.replaceAll(" ", "");

            Iterator<String> it = keys.iterator();
            while(it.hasNext()){
                String key = it.next(); //키 하나 뽑음
                if(locationStr.contains(key)){ //키를 포함하는지 비교
                    locationCode = ac.getAddressCode(key);
                    break;
                }
            }
            Toast.makeText(this, "정보를 불러왔습니다", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "정보를 불러올 수 없습니다", Toast.LENGTH_SHORT).show();
        }

        new WeatherThread().start();
    }

    LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            latitude = location.getLatitude();
            longitude = location.getLongitude();
            Log.i("MyTag", latitude + " , " + longitude);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };


    @Override
    protected void onDestroy() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.removeUpdates(locationListener);

        super.onDestroy();
    }

    class WeatherThread extends Thread{

        @Override
        public void run() {

            //요청 URL 전송
            String queryURL = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone="+locationCode;

            String tag, str;

            int year=-1, month=-1, day=-1, hour=-1;
            String temp= "";
            String desc= "";
            String rainPercent = "";

            try {

                URL url = new URL(queryURL);
                InputStream is = url.openStream();
                InputStreamReader isr = new InputStreamReader(is);

                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                XmlPullParser xpp = factory.newPullParser();
                xpp.setInput(isr);

                xpp.next();
                int eventType = xpp.getEventType(); //START_DOCUMENT 내놓음

                i = 0;
                while(true){ //4번 반복

                    if(eventType == XmlPullParser.START_TAG){
                        tag = xpp.getName();

                        if(tag.equals("category")){
                            xpp.next();
                            location = xpp.getText();
                        }

                        else if(tag.equals("tm")){
                            xpp.next();
                            str = xpp.getText();
                            year = Integer.parseInt(str.substring(0,4));
                            month = Integer.parseInt(str.substring(4, 6));
                            day = Integer.parseInt(str.substring(6, 8));
                        } else if(tag.equals("hour")){
                            xpp.next();
                            hour = Integer.parseInt(xpp.getText());

                        } else if(tag.equals("day")){
                            xpp.next();
                            day +=  Integer.parseInt(xpp.getText());
                        } else if(tag.equals("temp")){
                            xpp.next();
                            temp = xpp.getText();
                        } else if(tag.equals("wfKor")){
                            xpp.next();
                            desc = xpp.getText();
                        } else if(tag.equals("pop")){
                            xpp.next();
                            rainPercent=xpp.getText();
                        }

                    } else if(eventType == XmlPullParser.END_TAG){
                        tag = xpp.getName();

                        if(tag.equals("data")){

                            buffer = new StringBuffer();
                            buffer.append(year+"/"+month+"/"+day+"\n");
                            buffer.append((hour-3)+"시 ~ "+hour+"시\n\n");
                            buffer.append("날씨 : "+desc+"\n\n");
                            buffer.append("온도 : "+temp+"도\n");
                            buffer.append("강수확률 : " + rainPercent + "%\n");

                            if(i==0) result1 = buffer.toString();
                            else if(i==1) result2 = buffer.toString();
                            else if(i==2) result3 = buffer.toString();
                            else if(i==3) result4 = buffer.toString();

                            descArr[i] = desc;
                            i++;
                        }
                    } else if(eventType == XmlPullParser.END_DOCUMENT){
                        return;
                    }

                    eventType = xpp.next(); //다음 이벤트 타입 받음

                    if(i==4) break;

                }//end while

            } catch(Exception e){
                Log.i("MyTag", e.toString());
                return;
            }

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    txtWeatherTitle.setText(location);
                    txtWeather1.setText(result1);
                    txtWeather2.setText(result2);
                    txtWeather3.setText(result3);
                    txtWeather4.setText(result4);

                    for(int i=0; i<4; i++){
                        ImageView iv = (ImageView)findViewById(R.id.weather_img1+i);

                        if(descArr[i].equals("맑음")){
                            iv.setImageResource(R.drawable.wt_sun);
                        }else if(descArr[i].equals("구름 조금")){
                            iv.setImageResource(R.drawable.wt_cloud_s);
                        }else if(descArr[i].equals("구름 많음")){
                            iv.setImageResource(R.drawable.wt_cloud_m);
                        }else if(descArr[i].equals("흐림")){
                            iv.setImageResource(R.drawable.wt_fog);
                        }else if(descArr[i].equals("비")){
                            iv.setImageResource(R.drawable.wt_rain);
                        }else if(descArr[i].equals("눈/비")){
                            iv.setImageResource(R.drawable.wt_rain_snow);
                        }else if(descArr[i].equals("눈")){
                            iv.setImageResource(R.drawable.wt_snow);
                        }
                    }
                }
            });
        } //end run
    }



    public void mOnClick(View v){
        switch(v.getId()){

            case R.id.btn_refresh:
                mGetLocation();
                Toast.makeText(this, "정보를 불러옵니다", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_weather_complete:

                Bundle bundle = getIntent().getBundleExtra("BUNDLE");
                TimeItem ti = (TimeItem)bundle.getSerializable("TIME_ITEM");
                Intent intent1 = null;

                if(ti.isShake()){
                    //흔들어야 꺼짐
                    intent1 = new Intent(this, ShakeActivity.class);
                } else if(ti.getGameChoice()!=0){

                    if(ti.getGameChoice() == 1){
                        //1 to50 게임
                        intent1 = new Intent(this, Game1to50Activity.class);
                    }else if(ti.getGameChoice() == 2){
                        //버블 터뜨리기
                        intent1 = new Intent(this, GameBubbleActivity.class);
                    }

                } else {
                    //기본 알람울림 화면
                    intent1 = new Intent(this, RingActivity.class);
                }

                intent1.putExtra("BUNDLE", bundle);
                intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent1);
                finish();
                break;
        }

    }

    @Override
    public void onBackPressed() {

    }
}
