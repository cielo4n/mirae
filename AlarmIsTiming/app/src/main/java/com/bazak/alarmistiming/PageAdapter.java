package com.bazak.alarmistiming;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by alfo12 on 2016-02-05.
 */
public class PageAdapter extends FragmentPagerAdapter{

    Fragment fragment1 = new AlarmSetGeneralFragment();
    Fragment fragment2 = new AlarmSetPlusFragment();

    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return fragment1;
            case 1: return fragment2;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2; //페이지의 개수 == 탭의 개수
    }

    public Fragment getFragment(int pos){
        if(pos == 0) return fragment1;
        if(pos == 1) return fragment2;

        return null;
    }
}
