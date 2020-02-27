package com.example.app0121_2.Adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app0121_2.ListviewItem;
import com.example.app0121_2.Objs.Animal;
import com.example.app0121_2.R;
import com.example.app0121_2.RecyclerActivity;
import com.example.app0121_2.SecondActivity;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private final String LOG_TAG = "MyAdapter";

    public static final int ITEM_VIEW_TYPE_GREEN = 0;
    public static final int ITEM_VIEW_TYPE_RED = 1;
    public static final int ITEM_VIEW_TYPE_MAX = 2;

    public ArrayList<ListviewItem> listViewItemList = new ArrayList<>();

    public MyAdapter() {

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

    public class ListviewHolder {
        public ImageView greenIcon;
        public TextView greenName;
        public TextView greenFeed;
        public ImageView redIcon;
        public TextView redName;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Context context = parent.getContext();
        int viewType = getItemViewType(position);

        ListviewHolder holder;

        ListviewItem listviewItem = listViewItemList.get(position);

        if (convertView == null) {
            holder = new ListviewHolder();

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            switch (viewType) {
                case ITEM_VIEW_TYPE_GREEN:
                    convertView = inflater.inflate(R.layout.item1, parent, false);

                    holder.greenIcon = (ImageView) convertView.findViewById(R.id.item1_imageView);
                    holder.greenName = (TextView) convertView.findViewById(R.id.item1_name);
                    holder.greenFeed = (TextView) convertView.findViewById(R.id.item1_feed);
                    break;

                case ITEM_VIEW_TYPE_RED:
                    convertView = inflater.inflate(R.layout.item2, parent, false);

                    holder.redIcon = (ImageView) convertView.findViewById(R.id.item2_imageView);
                    holder.redName = (TextView) convertView.findViewById(R.id.item2_textView);
                    break;
            }
            convertView.setTag(holder);
        } else {
            holder = (ListviewHolder) convertView.getTag();
        }

        switch (viewType) {
            case ITEM_VIEW_TYPE_GREEN:
                holder.greenIcon.setImageResource(listviewItem.getIcon());
                holder.greenName.setText(listviewItem.getName() + convertView.getResources().getString(R.string.done_text));
                holder.greenFeed.setText(convertView.getResources().getString(R.string.now_text) + " " + listviewItem.getFeed() + convertView.getResources().getString(R.string.feedG_text));
                break;
            case ITEM_VIEW_TYPE_RED:
                holder.redIcon.setImageResource(listviewItem.getIcon());
                holder.redName.setText(listviewItem.getName() + convertView.getResources().getString(R.string.ndone_text));
                break;
        }

        return convertView;
    }

    public void addItem(int icon, String name, int feed) {
        ListviewItem item = new ListviewItem();
        item.setType(ITEM_VIEW_TYPE_GREEN);
        item.setIcon(icon);
        item.setName(name);
        item.setFeed(feed);

        listViewItemList.add(item);
        notiHandler();
    }

    public void addItem(int icon, String name) {
        ListviewItem item = new ListviewItem();
        item.setType(ITEM_VIEW_TYPE_RED);
        item.setIcon(icon);
        item.setName(name);

        listViewItemList.add(item);
        notiHandler();
    }

    public void notiHandler() {
        ((SecondActivity) SecondActivity.mContext).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ((SecondActivity) SecondActivity.mContext).listView.smoothScrollToPosition(getCount() - 1);
                notifyDataSetChanged();
            }
        });

    }

}
