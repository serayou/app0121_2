package com.example.app0121_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

public class MyAdapter extends BaseAdapter {

    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<SampleData> sample;

    public MyAdapter(Context context, ArrayAdapter<SampleData> data){
        mContext=context;
        sample=data;
        mLayoutInflater=LayoutInflater.from(mContext);
    }

}
