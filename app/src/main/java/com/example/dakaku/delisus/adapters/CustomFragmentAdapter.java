package com.example.dakaku.delisus.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dakaku on 16/2/18.
 */

public class CustomFragmentAdapter extends FragmentPagerAdapter {

    List<Fragment> mFragmentList=new ArrayList<>();
    List<String> mFragmentTitleList=new ArrayList<>();

    public CustomFragmentAdapter(FragmentManager fm) {
        super(fm);

    }

    public void addFragment(Fragment fragment, String title){
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
