package com.example.app0121_2.AnimalInfo.frag;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.app0121_2.Objs.Animal.Animal;
import com.example.app0121_2.Objs.Tom;
import com.example.app0121_2.R;

public class BirdFragment extends Fragment {

    private ImageView animalImage;
    private TextView feedVolume;
    private TextView animalActivity;
    private TextView animalTotalfeed;


    public BirdFragment(){

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_bird, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        animalImage = (ImageView)getView().findViewById(R.id.bird_image);
        feedVolume = (TextView)getView().findViewById(R.id.bird_FeedVolume);
        animalActivity=(TextView)getView().findViewById(R.id.bird_activity) ;
        animalTotalfeed=(TextView)getView().findViewById(R.id.bird_TotalFeed);

        animalImage.setImageResource(R.drawable.icon_bird);
        feedVolume.setText("50");
        animalActivity.setText("fly, walk");
//        animalTotalfeed.setText(Integer.toString());


    }
}
