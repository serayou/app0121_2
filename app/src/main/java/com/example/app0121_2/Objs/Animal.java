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
import com.example.app0121_2.SecondActivity;

import java.util.ArrayList;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public abstract class Animal {
    private final String LOG_TAG = "Animal";

    public final static int DAY_FEED_MAX_COUNT = 3;           //하루 3끼 최대
    public int feedVolume = 0;
    public int eatFeeds = 0;
    public String name = "";
    public int animalIcon = 0;

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

    public int eat(int feed) {

        if (feed >= feedVolume) {
            Log.i(LOG_TAG, name + "가 먹이를 먹었습니다.");
            eatFeeds += feedVolume;
            Log.i(LOG_TAG, "현재까지 " + name + "가 먹은 양 : " + eatFeeds);
            feed -= feedVolume;
            Log.i(LOG_TAG, "남은 먹이 양 : " + feed);

            ((SecondActivity)SecondActivity.mContext).showProgress(animalIcon, name, eatFeeds);



            return feed;
        } else {
            Log.i(LOG_TAG, name + "가 먹이를 먹지 못하였습니다.");

            ((SecondActivity)SecondActivity.mContext).showAnimal(animalIcon, name);

            return feed;
        }
    }

    public abstract void move();

}
