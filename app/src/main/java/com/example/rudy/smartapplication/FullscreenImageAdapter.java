package com.example.rudy.smartapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.wear.widget.BoxInsetLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;

/**
 * Created by Rudy on 29.05.2018.
 */

public class FullscreenImageAdapter extends PagerAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private ArrayList<Integer> imagesId;
    private Boolean isRound;

    public FullscreenImageAdapter(Activity activity, ArrayList<Integer> imagesId, Boolean isRound) {
        this.activity = activity;
        this.imagesId = imagesId;
        this.isRound = isRound;
    }

    @Override
    public int getCount() {
        return imagesId.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (LinearLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView;
        BoxInsetLayout layout = activity.findViewById(R.id.boxInsetLayout);

        inflater = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewLayout = inflater.inflate(R.layout.layout_fullscreen_image, container,
                false);

        imageView = viewLayout.findViewById(R.id.imageView);

        if(isRound){
            layout.setBackground(ContextCompat.getDrawable(activity.getApplicationContext(), imagesId.get(position)));
        }
        else{
            imageView.setImageResource(imagesId.get(position));
            container.addView(viewLayout);
        }

        return viewLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //((ViewPager) container).removeView((RelativeLayout) object);

    }
}
