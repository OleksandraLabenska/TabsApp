package com.example.tabs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.Objects;


public class Adaptor extends FragmentPagerAdapter {

    MainPageFragment mainPageFragment;
    Page1Fragment page1Fragment;
    Page2Fragment page2Fragment;

    public Adaptor(@NonNull FragmentManager fm) {
        super(fm);
    }

    //here I am  adapter for each page of application
    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {

            case 0:
                page1Fragment = new Page1Fragment();
                fragment = page1Fragment;
                break;
            case 1:
                page2Fragment = new Page2Fragment();
                fragment = page2Fragment;
                break;
            case 2:
                mainPageFragment = new MainPageFragment();
                fragment = mainPageFragment;
                break;
            default:
                fragment = null;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    //Here I set titles of the different pages
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title;

        switch (position) {
            case 0:
                title = "Page №1";
                break;
            case 1:
                title = "Page №2";
                break;
            case 2:
                title = "Change URL";
                break;
            default:
                title = "";
        }
        return title;
    }


    //Sending data to the fragment
    public void sendDataToPage1(String data) {
        page1Fragment.receiveUrl1(data);
    }

    public void sendDataToPage2(String data2) {
        page2Fragment.receiveUrl2(data2);
    }
}
