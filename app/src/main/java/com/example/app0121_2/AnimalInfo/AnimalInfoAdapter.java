package com.example.app0121_2.AnimalInfo;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.app0121_2.AnimalInfo.AnimalInfoFragment;
import com.example.app0121_2.Objs.Animal.Animal;
import com.example.app0121_2.Objs.Animal.Cat;
import com.example.app0121_2.Objs.Tom;


public class AnimalInfoAdapter extends FragmentPagerAdapter {
    private final String LOG_TAG = "AnimalInfoAdapter";


    public AnimalInfoAdapter(FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                //AnimalInfoFragment catInfo = new AnimalInfoFragment(position);
                return ((AnimalInfoActivity)AnimalInfoActivity.mContext).toFrag(position);
            case 1:
               // AnimalInfoFragment birdInfo = new AnimalInfoFragment(position);
                return ((AnimalInfoActivity)AnimalInfoActivity.mContext).toFrag(position);
            case 2:
                //AnimalInfoFragment turtleInfo = new AnimalInfoFragment(position);
                return ((AnimalInfoActivity)AnimalInfoActivity.mContext).toFrag(position);
        }

        return null;

       // Fragment fragment = AnimalInfoFragment.newInstance(position);
        //((AnimalInfoActivity)AnimalInfoActivity.mContext).toFrag();

//        return  ((AnimalInfoActivity)AnimalInfoActivity.mContext).toFrag();

    }

    @Override
    public int getCount() {
        return 3;
    }


    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

}
