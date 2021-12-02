package com.example.tabs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabs;
    ViewPager pages;
    Adaptor adaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabs = findViewById(R.id.tabs);
        //here I set the adaptor for pages
        pages = findViewById(R.id.pages);
        adaptor = new Adaptor(getSupportFragmentManager());
        pages.setAdapter(adaptor);

        tabs.setupWithViewPager(pages);

    }

    //Here I receive info from user I send it to fragment through adaptor
    public void receiveUrl1(String data) {

        adaptor.sendDataToPage1(data);
    }

    public void receiveUrl2(String data2) {

        adaptor.sendDataToPage2(data2);
    }


}

