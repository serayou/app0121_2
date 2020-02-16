package com.example.app0121_2.Objs;

import android.util.Log;

public abstract class Animal {

    private final String LOG_TAG = "Animal";

    public final static int DAY_FEED_MAX_COUNT = 3;
    public int feedVolume = 0;
    public int eatFeeds = 0;
    public String name = "";

    protected void setName(String name) {
        this.name = name;
        Log.i(LOG_TAG, name + "가 들어왔습니다.");
    }

    public void setFeedVolume(int volume) {
        feedVolume = volume;
        Log.i(LOG_TAG, name + "가 먹을 수 있는 먹이 양은 " + feedVolume + " 그램 입니다.");

    }

    public int eat(int feed) {
        if(feed >= feedVolume) {
            Log.i(LOG_TAG, name + "가 먹이를 먹었습니다.");
            eatFeeds += feedVolume;
            Log.i(LOG_TAG, "현재까지 " + name + "가 먹은 양 : " + eatFeeds);
            feed -= feedVolume;
            return feed;
        } else {
            Log.i(LOG_TAG, name + "가 먹이를 먹지 못하였습니다.");
            return feed;
        }
    }

    public abstract void move();
}
