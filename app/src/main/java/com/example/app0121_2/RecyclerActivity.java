package com.example.app0121_2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app0121_2.Adapter.MyAdapter;
import com.example.app0121_2.Adapter.RecyclerAdapter;
import com.example.app0121_2.Objs.Person;
import com.example.app0121_2.Objs.Tom;
import com.example.app0121_2.scheduler.FeedScheduler;

import java.util.ArrayList;
import java.util.Dictionary;

public class RecyclerActivity extends AppCompatActivity {
    private static final String LOG_TAG = "RecyclerActivity";
    public static Context mContext;
    private TextView textId;
    private TextView textName;
    public TextView textRemain;

    private EditText editTotalFeed;  //입력 먹이양
    private EditText editTime;       //입력 끼니시간
    public RecyclerView recyclerView;

    private FeedScheduler scheduler;

    int feed;
    int duration;
    public int flag;

    ArrayList<ListviewItem> list=new ArrayList<>();
    RecyclerAdapter adapter =new RecyclerAdapter(list);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        mContext = this;

        initLayout();
        initScheduler();

        Intent intent = getIntent();
        Person person = (Person) intent.getSerializableExtra("person");

        textId.setText("[" + person.id + "]");
        textName.setText(person.name);

        flag=2;

        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new WrapContentLinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);
    }

    private static class WrapContentLinearLayoutManager extends LinearLayoutManager{
        @Override
        public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
            try {
                super.onLayoutChildren(recycler, state);
            }catch (IndexOutOfBoundsException e){
                Log.e(LOG_TAG,"meet a IOOBE in RecyclerView");
            }
        }
        public WrapContentLinearLayoutManager(Context context){
            super(context);
        }
        public WrapContentLinearLayoutManager(Context context, int orientation, boolean reverseLayout){
            super(context,orientation,reverseLayout);
        }
        public WrapContentLinearLayoutManager(Context context, AttributeSet attributeSet,int defStyleArr,int defStyleRes ){
            super(context,attributeSet,defStyleArr,defStyleRes);
        }
        @Override
        public boolean supportsPredictiveItemAnimations() {
            return false;
        }
    }

    private void initLayout() {
        editTotalFeed = (EditText) findViewById(R.id.feed_edittext);
        editTime = (EditText) findViewById(R.id.time_edittext);
        textId = findViewById(R.id.secondLayoutId);
        recyclerView = findViewById(R.id.progressRecyclerView);
        textName = findViewById(R.id.secondLayoutName);
        textRemain = findViewById(R.id.remainFeed);
//        ((Button)findViewById(R.id.stop_button)).setOnClickListener(clickListener);
    }

    private void initScheduler() {
        scheduler = new FeedScheduler();
        scheduler.setManager(new Tom());
        scheduler.setFeed(10000);
        scheduler.setDuration(1000);
    }

    private void runScheduler() {
        scheduler.startScheduleToFeed(flag);
    }
    private void stopScheduler() { scheduler.stopSchedule(); }

    public boolean fillCheck(EditText editText) {
        if (editText.getText().toString().length() != 0) {
            return true;
        } else {
            return false;
        }
    }

    public void stopButtonOnClick(View view) {
        stopScheduler();

        editTotalFeed.getText().clear();
        editTime.getText().clear();
        showText(0);

        list.clear();
        Message msg = handler.obtainMessage();
        handler.sendMessage(msg);

        Log.i(LOG_TAG, "먹이공급 초기화..");

    }
    public void startButtonOnClick(View view) {
        initScheduler();
        if ((fillCheck(editTotalFeed) && fillCheck(editTime))) {

            feed = Integer.parseInt(editTotalFeed.getText().toString());
            duration = Integer.parseInt(editTime.getText().toString());

            scheduler.setFeed(feed);
            scheduler.setDuration(duration);
            runScheduler();

        } else {
            if (!fillCheck(editTotalFeed)) {
                Toast.makeText(RecyclerActivity.this, "먹이 양을 입력해주세요!", Toast.LENGTH_SHORT).show();
            }
            if (!fillCheck(editTime)) {
                Toast.makeText(RecyclerActivity.this, "끼니시간을 입력해주세요!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void showProgress(int icon, String name, int feed) {
        adapter.addItem(icon, name, feed);
    }

    public void showAnimal(int icon, String name) {
        adapter.addItem(icon, name);
    }

    public void showText(final int remainFeed) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textRemain.setText(remainFeed + "개");
                Log.i(LOG_TAG, String.format("[실시간 남은 먹이양] : "+ remainFeed));
            }
        });
    }

    final Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            adapter.notifyDataSetChanged();
        }
    };

}
