package com.example.app0121_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter  {
   private LayoutInflater inflater;
   private ArrayList<ListviewItem> data;
   private int layout;

   public MyAdapter(Context context, int layout,ArrayList<ListviewItem> data){
      notifyDataSetChanged();
      this.inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      this.data=data;
      this.layout=layout;
   }

   @Override
   public int getCount() {
      return data.size();
   }


   @Override
   public String getItem(int position){
      return data.get(position).getName();
   }

   @Override
   public long getItemId(int position) {
      return position;
   }

   @Override
   public View getView(int position, View convertView, ViewGroup parent) {


      if(convertView==null){
         convertView=inflater.inflate(layout,parent,false);
      }

      ListviewItem listviewItem=data.get(position);

      ImageView icon=(ImageView)convertView.findViewById(R.id.item2_imageView);
      TextView name=(TextView)convertView.findViewById(R.id.item2_textView);

      icon.setImageResource(listviewItem.getIcon());
      name.setText(listviewItem.getName()+convertView.getResources().getString(R.string.ndone_text));

      return convertView;
   }

}
