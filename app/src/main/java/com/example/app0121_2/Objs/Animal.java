package com.example.app0121_2.Objs;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.example.app0121_2.MyAdapter;
import com.example.app0121_2.R;

public abstract class Animal {
    static Context mContext;
    public ListView listView;

    private final String LOG_TAG = "Animal";

    public TextView textRemainFeed;

    public final static int DAY_FEED_MAX_COUNT = 3;           //하루 3끼 최대
    public int feedVolume = 0;
    public int eatFeeds = 0;
    public String name = "";

    MyAdapter adapter=new MyAdapter();

    public static void InitAnimal(Context context){
        mContext=context;
    }

    protected void setName(String name) {
        this.name = name;
        Log.i(LOG_TAG, name + "가 들어왔습니다.");
    }


    public void setFeedVolume(int volume) {
        feedVolume = volume;
        Log.i(LOG_TAG, name + "가 먹을 수 있는 먹이 양은 " + feedVolume + " 그램 입니다.");

    }

    private void showText(final TextView textView,final int remainfeed){
        ((Activity) mContext).runOnUiThread(new Runnable(){
            @Override
            public void run(){
                textView.setText(remainfeed + "개");
            }
        });
    }

    private void showAnimal(final String name){
        ((Activity) mContext).runOnUiThread(new Runnable(){
            @Override
            public void run(){
                listView.setAdapter(adapter);


                if(name=="고양이"){
                   adapter.addItem(R.drawable.icon_cat,name);

                }
                if(name=="참새"){
                    adapter.addItem(R.drawable.icon_bird,name);
                }
                if(name=="거북이") {
                    adapter.addItem(R.drawable.icon_turtle,name);

                }

            }
        });
    }

    private void showProgress(final String name,final int feed){
        ((Activity) mContext).runOnUiThread(new Runnable(){
            @Override
            public void run(){
                listView.setAdapter(adapter);


                if(name=="고양이"){
                    adapter.addItem(R.drawable.icon_cat,name,feed);
                }
                if(name=="참새"){
                    adapter.addItem(R.drawable.icon_bird,name,feed);
                }
                if(name=="거북이"){
                    adapter.addItem(R.drawable.icon_turtle,name,feed);
                }


            }
        });
    }



    public int eat(int feed) {

        textRemainFeed=((Activity)mContext).findViewById(R.id.remainFeed);
        listView=((Activity)mContext).findViewById(R.id.progressListView);


        if(feed >= feedVolume) {
            Log.i(LOG_TAG, name + "가 먹이를 먹었습니다.");
            eatFeeds += feedVolume;
            Log.i(LOG_TAG, "현재까지 " + name + "가 먹은 양 : " + eatFeeds);

            showProgress(name,eatFeeds);

            feed -= feedVolume;                                   //feed : tom 이 가지고 있는 양 , feedvoloume : 고양이가 먹는양
            Log.i(LOG_TAG, "남은 먹이 양 : " + feed);

            showText(textRemainFeed,feed);                         //남은 먹이양 textview에 feed를 실시간으로 표시

            return feed;
        } else {
            Log.i(LOG_TAG, name + "가 먹이를 먹지 못하였습니다.");

            showAnimal(name);

            return feed;
        }
    }

    public abstract void move();






}
