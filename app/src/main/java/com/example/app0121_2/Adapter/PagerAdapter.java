package com.example.app0121_2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.app0121_2.AnimalInfo.BirdFragment;
import com.example.app0121_2.AnimalInfo.CatFragment;
import com.example.app0121_2.AnimalInfo.TurtleFragment;
import com.example.app0121_2.Objs.Animal.Turtle;
import com.example.app0121_2.R;


public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfPage;
    public PagerAdapter(FragmentManager fragmentManager,int NumOfPage) {
        super(fragmentManager);
        this.mNumOfPage=NumOfPage;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                CatFragment catFragment=new CatFragment();
                return catFragment;
            case 1:
                BirdFragment birdFragment=new BirdFragment();
                return birdFragment;
            case 2:
                TurtleFragment turtleFragment=new TurtleFragment();
                return turtleFragment;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return mNumOfPage;
    }
}
