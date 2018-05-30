package com.example.rudy.smartapplication;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.wearable.activity.WearableActivity;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends WearableActivity {

    private ViewPager viewPager;
    private ArrayList<Integer> imagesID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enables Always-on
        setAmbientEnabled();

        setReferences();
        setViewPagerAdapter();
    }

    public void setReferences(){
        this.viewPager = findViewById(R.id.pager);
        fillImagesID();
    }

    public void setViewPagerAdapter(){
        this.viewPager.setAdapter(new FullscreenImageAdapter(MainActivity.this, imagesID, getResources().getConfiguration().isScreenRound()));
    }

    public void fillImagesID(){
        imagesID = new ArrayList<>();
        imagesID.add(R.drawable.picture_1);
        imagesID.add(R.drawable.picture_2);
        imagesID.add(R.drawable.picture_3);
        imagesID.add(R.drawable.picture_4);
        imagesID.add(R.drawable.picture_5);

    }

    public void setBackground(){

    }
}
