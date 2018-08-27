package com.bazak.alarmistiming;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameBubbleActivity extends AppCompatActivity {

    Button btnConfirm;
    TextView bubbleCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_bubble);

        btnConfirm = (Button)findViewById(R.id.btn_game_bubble_complete);
        bubbleCount = (TextView)findViewById(R.id.bubble_count);
    }

    public void mOnClick(View v){
        switch(v.getId()){
            case R.id.btn_game_bubble_complete:
                Intent intent1 = new Intent(this, RingActivity.class);
                intent1.putExtra("BUNDLE", getIntent().getBundleExtra("BUNDLE"));
                intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent1);
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }
}
