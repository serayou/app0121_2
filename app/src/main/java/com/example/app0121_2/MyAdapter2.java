package com.example.app0121_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter2 extends BaseAdapter  {
   private LayoutInflater inflater;
   private ArrayList<ListviewItem> data;
   private int layout;

   public MyAdapter2(Context context, int layout, ArrayList<ListviewItem> data){
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

      ImageView icon=(ImageView)convertView.findViewById(R.id.item1_imageView);
      TextView name=(TextView)convertView.findViewById(R.id.item1_name);
      TextView feed=(TextView)convertView.findViewById(R.id.item1_feed);

      icon.setImageResource(listviewItem.getIcon());
      name.setText(listviewItem.getName()+convertView.getResources().getString(R.string.done_text));
      feed.setText(convertView.getResources().getString(R.string.now_text)+listviewItem.getFeed()+convertView.getResources().getString(R.string.feedG_text));

      return convertView;
   }


}