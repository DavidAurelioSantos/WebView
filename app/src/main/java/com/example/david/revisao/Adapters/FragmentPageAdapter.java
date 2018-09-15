package com.example.david.revisao.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

//o segundo FragmentPagerAdapter é padrão do Android
public class FragmentPageAdapter extends FragmentPagerAdapter {

    List<Fragment> fragmentList;
    List<String> titleFragment;

    public FragmentPageAdapter(FragmentManager fm,List<Fragment> fragmentList, List<String> titleFragment) {
        super(fm);
        this.fragmentList = fragmentList;
        this.titleFragment = titleFragment;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return titleFragment.get(position);
    }

}
