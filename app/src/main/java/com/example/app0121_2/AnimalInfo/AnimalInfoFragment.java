package com.example.app0121_2.AnimalInfo;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.app0121_2.Objs.Animal.Animal;
import com.example.app0121_2.Objs.Tom;
import com.example.app0121_2.R;

public class AnimalInfoFragment extends Fragment {
    private final String LOG_TAG = "AnimalInfoFragment";
    public static final String ANIMAL_INFOMATION = "ANIMAL_INFOMATION";
    public Tom tom =new Tom() ;

    public ImageView animalImage;
    public TextView feedVolume;
    public TextView animalActivity;
    public TextView totalFeed;

    private int catfeed=0;
    private int birdfeed=0;
    private int turtlefeed=0;

    private int mPosition;
    private int eatfeeds;

    public AnimalInfoFragment() {

    }

    public static AnimalInfoFragment newInstance(int page)
    {
        AnimalInfoFragment fragment = new AnimalInfoFragment();

        Bundle args = new Bundle();
        args.putInt(ANIMAL_INFOMATION, page);
        fragment.setArguments(args);

        return fragment;
    }



    public AnimalInfoFragment(int position,int feed) {
        this.mPosition = position;
        this.eatfeeds=feed;

    }

    public AnimalInfoFragment(int position) {
        this.mPosition = position;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        catfeed=getArguments().getInt("cat");
        birdfeed=getArguments().getInt("bird");
        turtlefeed=getArguments().getInt("turtle");

        return inflater.inflate(R.layout.fragment_bird, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

 //       mPosition=getArguments().getInt(ANIMAL_INFOMATION);

        animalImage = (ImageView) getView().findViewById(R.id.bird_image);
        feedVolume = (TextView) getView().findViewById(R.id.bird_FeedVolume);
        animalActivity = (TextView) getView().findViewById(R.id.bird_activity);
        totalFeed=(TextView)getView().findViewById(R.id.bird_TotalFeed);

        switch (mPosition) {
            case 0:
                animalImage.setImageResource(tom.cat.getAnimalIcon());
                feedVolume.setText(Integer.toString(tom.cat.getFeedVolume()));
                animalActivity.setText(tom.cat.getActivity());
                totalFeed.setText(Integer.toString(catfeed));
                break;
            case 1:
                animalImage.setImageResource(tom.sparrow.getAnimalIcon());
                feedVolume.setText(Integer.toString(tom.sparrow.getFeedVolume()));
                animalActivity.setText(tom.sparrow.getActivity());
                totalFeed.setText(Integer.toString(birdfeed));
                break;
            case 2:
                animalImage.setImageResource(tom.turtle.getAnimalIcon());
                feedVolume.setText(Integer.toString(tom.turtle.getFeedVolume()));
                animalActivity.setText(tom.turtle.getActivity());
                totalFeed.setText(Integer.toString(turtlefeed));
                break;
        }

    }

}
