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
   private static final int ITEM_VIEW_TYPE_GREEN=0;
   private static final int ITEM_VIEW_TYPE_RED=1;
   private static final int ITEM_VIEW_TYPE_MAX=2;

   private ArrayList<ListviewItem> listViewItemList = new ArrayList<>() ;

   public MyAdapter(){
      notifyDataSetChanged();

   }

   @Override
   public int getCount() {
      return listViewItemList.size();
   }

   @Override
   public int getViewTypeCount() {
      return ITEM_VIEW_TYPE_MAX;
   }

   @Override
   public int getItemViewType(int position) {
      return listViewItemList.get(position).getType();
   }

   @Override
   public long getItemId(int position) {
      return position;
   }

   @Override
   public Object getItem(int position) {
      return listViewItemList.get(position);
   }

   @Override
   public View getView(int position, View convertView, ViewGroup parent) {
      final Context context=parent.getContext();
      int viewType=getItemViewType(position);

      if(convertView==null) {
         LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

         ListviewItem listviewItem = listViewItemList.get(position);

         switch (viewType) {
            case ITEM_VIEW_TYPE_GREEN:
               convertView = inflater.inflate(R.layout.item1, parent, false);
               ImageView greenIcon = (ImageView) convertView.findViewById(R.id.item1_imageView);
               TextView greenName = (TextView) convertView.findViewById(R.id.item1_name);
               TextView greenFeed = (TextView) convertView.findViewById(R.id.item1_feed);

               greenIcon.setImageResource(listviewItem.getIcon());
               greenName.setText(listviewItem.getName() + convertView.getResources().getString(R.string.done_text));
               greenFeed.setText(convertView.getResources().getString(R.string.now_text) +" "+ listviewItem.getFeed() + convertView.getResources().getString(R.string.feedG_text));
               break;


            case ITEM_VIEW_TYPE_RED:
               convertView = inflater.inflate(R.layout.item2, parent, false);
               ImageView redIcon = (ImageView) convertView.findViewById(R.id.item2_imageView);
               TextView redName = (TextView) convertView.findViewById(R.id.item2_textView);

               redIcon.setImageResource(listviewItem.getIcon());
               redName.setText(listviewItem.getName() + convertView.getResources().getString(R.string.ndone_text));
               break;

         }
      }

      return convertView;
   }

   public void addItem(int icon,String name,int feed){
      ListviewItem item=new ListviewItem();
      item.setType(ITEM_VIEW_TYPE_GREEN);
      item.setIcon(icon);
      item.setName(name);
      item.setFeed(feed);

      listViewItemList.add(item);

   }
   public void addItem(int icon, String name){
      ListviewItem item=new ListviewItem();
      item.setType(ITEM_VIEW_TYPE_RED);
      item.setIcon(icon);
      item.setName(name);


      listViewItemList.add(item);
   }



}
