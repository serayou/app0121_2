package com.example.app0121_2.AnimalInfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.example.app0121_2.Adapter.AnimalInfoPagerAdapter;
import com.example.app0121_2.Adapter.PagerAdapter;
import com.example.app0121_2.Objs.Tom;
import com.example.app0121_2.R;

public class AnimalInfoActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_info);

        viewPager=(ViewPager)findViewById(R.id.aniamlInfo_ViewPager);
        pagerAdapter =new PagerAdapter(getSupportFragmentManager(),3);
        viewPager.setAdapter(pagerAdapter);
       // viewPager.addOnAdapterChangeListener();
    }
}
