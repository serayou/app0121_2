package com.example.app0121_2.Objs;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.app0121_2.ListviewItem;
import com.example.app0121_2.MyAdapter;
import com.example.app0121_2.R;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public abstract class Animal {
    private final String LOG_TAG = "Animal";

    static Context mContext;
    public ListView listView;
    public TextView textRemainFeed;

    public final static int DAY_FEED_MAX_COUNT = 3;           //하루 3끼 최대
    public int feedVolume = 0;
    public int eatFeeds = 0;
    public String name = "";
    public int animalIcon = 0;

    MyAdapter adapter = new MyAdapter();

    public static void InitAnimal(Context context) {
        mContext = context;
    }

    protected void setName(String name) {
        this.name = name;
        Log.i(LOG_TAG, name + "가 들어왔습니다.");
    }

    public void setFeedVolume(int volume) {
        feedVolume = volume;
        Log.i(LOG_TAG, name + "가 먹을 수 있는 먹이 양은 " + feedVolume + " 그램 입니다.");

    }

    public void setIcon(int icon) {
        animalIcon = icon;
    }

    private void showText(final TextView textView, final int remainFeed) {
        ((Activity) mContext).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter.notifyDataSetChanged();
                textView.setText(remainFeed + "개");
            }
        });

    }

    final android.os.Handler handler=new android.os.Handler(){
        public void handleMessage(Message msg){
            listView.setAdapter(adapter);
        }
    };


    public int eat(int feed) {

        textRemainFeed = ((Activity) mContext).findViewById(R.id.remainFeed);
        listView = ((Activity) mContext).findViewById(R.id.progressListView);

        Message msg=handler.obtainMessage();
        handler.sendMessage(msg);



        if (feed >= feedVolume) {
            Log.i(LOG_TAG, name + "가 먹이를 먹었습니다.");
            eatFeeds += feedVolume;
            Log.i(LOG_TAG, "현재까지 " + name + "가 먹은 양 : " + eatFeeds);

            adapter.showProgress(animalIcon, name, eatFeeds);


            feed -= feedVolume;                                    //feed : tom 이 가지고 있는 양 , feedvoloume : 고양이가 먹는양
            Log.i(LOG_TAG, "남은 먹이 양 : " + feed);

            showText(textRemainFeed, feed);                         //남은 먹이양 textview에 feed를 실시간으로 표시

            return feed;
        } else {
            Log.i(LOG_TAG, name + "가 먹이를 먹지 못하였습니다.");

            adapter.showAnimal(animalIcon, name);

            return feed;
        }
    }

    public abstract void move();


}
