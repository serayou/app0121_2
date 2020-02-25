package com.example.app0121_2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app0121_2.ListviewItem;
import com.example.app0121_2.R;
import com.example.app0121_2.RecyclerActivity;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private final String LOG_TAG = "RecyclerAdapter";

    private ArrayList<ListviewItem> mListviewItem;

    public static final int ITEM_VIEW_TYPE_GREEN = 0;
    public static final int ITEM_VIEW_TYPE_RED = 1;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView greenIcon;
        public TextView greenName;
        public TextView greenFeed;
        public ImageView redIcon;
        public TextView redName;

        public ViewHolder(View view) {
            super(view);
            greenIcon = (ImageView) view.findViewById(R.id.item1_imageView);
            greenName = (TextView) view.findViewById(R.id.item1_name);
            greenFeed = (TextView) view.findViewById(R.id.item1_feed);
            redIcon = (ImageView) view.findViewById(R.id.item2_imageView);
            redName = (TextView) view.findViewById(R.id.item2_textView);
        }
    }

    public RecyclerAdapter(ArrayList<ListviewItem> list) {
        mListviewItem = list;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = null;

        switch (viewType) {
            case ITEM_VIEW_TYPE_GREEN:
                view = inflater.inflate(R.layout.item1, parent, false);
                break;

            case ITEM_VIEW_TYPE_RED:
                view = inflater.inflate(R.layout.item2, parent, false);
                break;
        }
        RecyclerAdapter.ViewHolder myViewHolder = new RecyclerAdapter.ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        ListviewItem listviewItem = mListviewItem.get(position);

        switch (viewType) {
            case ITEM_VIEW_TYPE_GREEN:
                holder.greenIcon.setImageResource(listviewItem.getIcon());
                holder.greenName.setText(listviewItem.getName() + "가 식사를 마쳤습니다!");
                holder.greenFeed.setText("지금까지 " + listviewItem.getFeed() + "g 먹었습니다.");
                break;

            case ITEM_VIEW_TYPE_RED:
                holder.redIcon.setImageResource(listviewItem.getIcon());
                holder.redName.setText(listviewItem.getName() + "가 식사를 하지 못했습니다.");
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mListviewItem.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mListviewItem.get(position).getType();
    }

    public void addItem(int icon, String name, int feed) {
        ListviewItem item = new ListviewItem();
        item.setType(ITEM_VIEW_TYPE_GREEN);
        item.setIcon(icon);
        item.setName(name);
        item.setFeed(feed);

        mListviewItem.add(item);
        notiHandler();
    }

    public void addItem(int icon, String name) {
        ListviewItem item = new ListviewItem();
        item.setType(ITEM_VIEW_TYPE_RED);
        item.setIcon(icon);
        item.setName(name);

        mListviewItem.add(item);
        notiHandler();
    }

    public void notiHandler() {
        ((RecyclerActivity) RecyclerActivity.mContext).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ((RecyclerActivity) RecyclerActivity.mContext).recyclerView.smoothScrollToPosition(getItemCount() - 1);
                notifyDataSetChanged();
            }
        });

    }
}
