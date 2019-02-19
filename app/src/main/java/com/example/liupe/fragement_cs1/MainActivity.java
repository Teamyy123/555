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

public class MainActivity extends AppCompatActivity {
    ArrayList<View> viewArrayList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager1=(ViewPager)this.findViewById(R.id.scrollView_a1);
        View view1=LayoutInflater.from(this).inflate(R.layout.layout_tab1,null);
        View view2=LayoutInflater.from(this).inflate(R.layout.layout_tab2,null);
        View view3=LayoutInflater.from(this).inflate(R.layout.layout_tab3,null);
        View view4=LayoutInflater.from(this).inflate(R.layout.layout_tab4,null);

        viewArrayList.add(view1);
        viewArrayList.add(view2);
        viewArrayList.add(view3);
        viewArrayList.add(view4);
        viewPager1.setAdapter(new myAdpat());


    }

    class  myAdpat extends PagerAdapter{

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
