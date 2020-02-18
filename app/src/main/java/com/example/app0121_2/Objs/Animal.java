package com.example.app0121_2.Objs;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.app0121_2.ListviewItem;
import com.example.app0121_2.MyAdapter;
import com.example.app0121_2.MyAdapter2;
import com.example.app0121_2.R;
import com.example.app0121_2.SecondActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public abstract class Animal {
    static Context mContext;
    public ListView listView;

    private final String LOG_TAG = "Animal";

    public TextView textRemainFeed;

    public final static int DAY_FEED_MAX_COUNT = 3;           //하루 3끼 최대
    public int feedVolume = 0;
    public int eatFeeds = 0;
    public String name = "";

    ArrayList<ListviewItem> data = new ArrayList<>();

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

    private void showAnimal(){
        ((Activity) mContext).runOnUiThread(new Runnable(){
            @Override
            public void run(){
                MyAdapter adapter=new MyAdapter(mContext,R.layout.item2,data);
                listView.setAdapter(adapter);
            }
        });
    }

    private void showProgress(){
        ((Activity) mContext).runOnUiThread(new Runnable(){
            @Override
            public void run(){
                MyAdapter2 adapter2=new MyAdapter2(mContext,R.layout.item1,data);
                listView.setAdapter(adapter2);

            }
        });
    }



    public int eat(int feed) {

        textRemainFeed=((Activity)mContext).findViewById(R.id.remainFeed);
        listView=((Activity)mContext).findViewById(R.id.progressListView);

        ListviewItem cat=new ListviewItem(R.drawable.icon_cat,name,eatFeeds);
        ListviewItem bird=new ListviewItem(R.drawable.icon_bird,name,eatFeeds);
        ListviewItem turtle=new ListviewItem(R.drawable.icon_turtle,name,eatFeeds);

        if(feed >= feedVolume) {
            Log.i(LOG_TAG, name + "가 먹이를 먹었습니다.");
            eatFeeds += feedVolume;
            Log.i(LOG_TAG, "현재까지 " + name + "가 먹은 양 : " + eatFeeds);

            if(name=="고양이"){

                data.add(cat);
                showProgress();
            }
//            if(name=="참새"){
//
//                data.add(bird);
//                showProgress();
//            }
//            if(name=="거북이") {
//
//                data.add(turtle);
//                showProgress();
//            }



            feed -= feedVolume;                                   //feed : tom 이 가지고 있는 양 , feedvoloume : 고양이가 먹는양
            Log.i(LOG_TAG, "남은 먹이 양 : " + feed);

            showText(textRemainFeed,feed);                         //남은 먹이양 textview에 feed를 실시간으로 표시


            return feed;
        } else {
            Log.i(LOG_TAG, name + "가 먹이를 먹지 못하였습니다.");

            //먹지 못한 동물의 리스트?item?이 나타남
            if(name=="고양이"){
                data.add(cat);

            }else if(name=="참새"){
                data.add(bird);
            }else {
                data.add(turtle);
            }

            showAnimal();



            return feed;
        }
    }

    public abstract void move();






}
