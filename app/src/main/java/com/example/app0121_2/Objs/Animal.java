package com.example.app0121_2.Objs;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.app0121_2.R;
import com.example.app0121_2.SecondActivity;

import org.w3c.dom.Text;

public abstract class Animal {
    static Context mContext;

    ListView listView;

    String mTitle []={"고양이","참새","거북이"};
    int images[]={R.drawable.icon_cat,R.drawable.icon_bird, R.drawable.icon_turtle};

    private final String LOG_TAG = "Animal";

    public TextView textRemainFeed;

    public final static int DAY_FEED_MAX_COUNT = 3;           //하루 3끼 최대
    public int feedVolume = 0;
    public int eatFeeds = 0;
    public String name = "";

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

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String rTitle[];
        int rImgs[];

        MyAdapter(Context c, String title[], int imgs[]){
            super(c, R.layout.item2, R.id.item2_textView,title);
            this.context=c;
            this.rTitle=title;
            this.rImgs=imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            //LayoutInflater layoutInflater=(LayoutInflater)getApplicationContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
            LayoutInflater layoutInflater=(LayoutInflater)mContext.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View item2=layoutInflater.inflate(R.layout.item2,parent,false);

            ImageView images=item2.findViewById(R.id.item2_imageView);
            TextView myTitle=item2.findViewById(R.id.item2_textView);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]+"가 식사를 하지 못했습니다.");

            return item2;
        }
    }

    private void showText(final TextView textView,final int remainfeed){
        ((Activity) mContext).runOnUiThread(new Runnable(){
            @Override
            public void run(){
                textView.setText(remainfeed + "개");
            }
        });
    }

    final Handler handler=new Handler(){
        public void handleMessage(Message msg){

            MyAdapter adapter=new MyAdapter(mContext,mTitle,images);
            listView.setAdapter(adapter);
        }

    };


    public int eat(int feed) {

        textRemainFeed=((Activity)mContext).findViewById(R.id.remainFeed);
        listView=((Activity)mContext).findViewById(R.id.progressListView);


        if(feed >= feedVolume) {
            Log.i(LOG_TAG, name + "가 먹이를 먹었습니다.");
            eatFeeds += feedVolume;
            Log.i(LOG_TAG, "현재까지 " + name + "가 먹은 양 : " + eatFeeds);
            feed -= feedVolume;                                   //feed : tom 이 가지고 있는 양 , feedvoloume : 고양이가 먹는양
            Log.i(LOG_TAG, "남은 먹이 양 : " + feed);

            showText(textRemainFeed,feed);                         //남은 먹이양 textview에 feed를 실시간으로 표시

            return feed;
        } else {
            Log.i(LOG_TAG, name + "가 먹이를 먹지 못하였습니다.");


            //먹지 못한 동물의 리스트?item?이 나타남
            Message msg=handler.obtainMessage();
            handler.sendMessage(msg);


            return feed;
        }
    }

    public abstract void move();






}
