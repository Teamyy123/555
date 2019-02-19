package com.example.liupe.fragement_cs1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Main6Activity extends AppCompatActivity {

    ArrayList<View> viewArrayList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main6);
        ViewPager viewPager1=(ViewPager)this.findViewById(R.id.scrollView_a6);
        View view1=LayoutInflater.from(this).inflate(R.layout.layout_tab20,null);
        View view2=LayoutInflater.from(this).inflate(R.layout.layout_tab21,null);
        View view6=LayoutInflater.from(this).inflate(R.layout.layout_tab22,null);
        View view4=LayoutInflater.from(this).inflate(R.layout.layout_tab23,null);
        View view5=LayoutInflater.from(this).inflate(R.layout.layout_tab25,null);

        viewArrayList.add(view1);
        viewArrayList.add(view2);
        viewArrayList.add(view6);
        viewArrayList.add(view4);
        viewArrayList.add(view5);
        viewPager1.setAdapter(new Main6Activity.myAdpat());


    }

    class  myAdpat extends PagerAdapter {

        @Override
        public int getCount() {

            return viewArrayList.size();
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object)
        {

            ( (ViewPager)container).removeView(viewArrayList.get(position));
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            ((ViewPager)container).addView(viewArrayList.get(position));
            return viewArrayList.get(position);
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {

            return view==o;
        }
    }
}
