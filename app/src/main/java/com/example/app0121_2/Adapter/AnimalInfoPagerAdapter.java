package com.example.app0121_2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.app0121_2.R;


public class AnimalInfoPagerAdapter extends PagerAdapter {

    private Context mContext = null;

    public AnimalInfoPagerAdapter() {

    }

    public AnimalInfoPagerAdapter(Context context) {
        mContext = context;

    }

    @NonNull
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = null;

        if (mContext != null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.fragment_cat, container, false);

            ImageView animalInfo_Image = (ImageView) view.findViewById(R.id.animal_image);
            TextView animalInfo_name=(TextView)view.findViewById(R.id.animalInfo_name);
            TextView animalInfo_feedVolume=(TextView)view.findViewById(R.id.animalInfo_FeedVolume);
            TextView animalInfo_totalFeed=(TextView)view.findViewById(R.id.animalInfo_TotalFeed);
            TextView animalInfo_activity=(TextView)view.findViewById(R.id.animalInfo_activity);

//            animalInfo_Image.setImageResource();
//            animalInfo_name.setText();
        }

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(View)object);
    }
}
