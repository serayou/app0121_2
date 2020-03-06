package com.example.app0121_2.AnimalInfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.app0121_2.Objs.Animal.Cat;
import com.example.app0121_2.Objs.Animal.Sparrow;
import com.example.app0121_2.R;

public class BirdFragment extends Fragment {
    private View view=null;
    private Sparrow bird=new Sparrow();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bird,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//
//        TextView name=(TextView)
//                .findViewById(R.id.animalInfo_name);
//        name.setText(bird.name);


    }
}
