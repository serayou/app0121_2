package com.example.app0121_2.Adapter;



import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.app0121_2.AnimalInfo.BirdFragment;
import com.example.app0121_2.AnimalInfo.CatFragment;
import com.example.app0121_2.AnimalInfo.TurtleFragment;
import com.example.app0121_2.Objs.Tom;
import com.example.app0121_2.R;


public class AnimalInfoAdapter extends FragmentPagerAdapter {

    public AnimalInfoAdapter(FragmentManager fm) {
        super(fm);


    }


    @NonNull
    @Override
    public Fragment getItem(int position) {


        switch (position) {
            case 0:
                CatFragment cat = new CatFragment();
                return cat;
            case 1:
                BirdFragment bird = new BirdFragment();
                return bird;
            case 2:
                TurtleFragment turtle = new TurtleFragment();
                return turtle;
        }
        return null;

    }

    @Override
    public int getCount() {
        return 3;
    }
}
