package com.example.app0121_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app0121_2.Adapter.MyAdapter;
import com.example.app0121_2.Objs.Person;
import com.example.app0121_2.Objs.Tom;
import com.example.app0121_2.scheduler.FeedScheduler;

public class SecondActivity extends AppCompatActivity {
    private static final String LOG_TAG = "SecondActivity";
    public static Context mContext;
    private TextView textId;
    private TextView textName;
    public TextView textRemain;

    private EditText editTotalFeed;  //입력 먹이양
    private EditText editTime;       //입력 끼니시간
    public ListView listView;

    private FeedScheduler scheduler;

    int feed;
    int duration;
    public int flag;

    MyAdapter adapter = new MyAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mContext = this;

        initLayout();
        initScheduler();

        Intent intent = getIntent();
        Person person = (Person) intent.getSerializableExtra("person");

        textId.setText("[" + person.id + "]");
        textName.setText(person.name);

        listView.setAdapter(adapter);
        flag=1;

    }

    private void initLayout() {
        editTotalFeed = (EditText) findViewById(R.id.feed_edittext);
        editTime = (EditText) findViewById(R.id.time_edittext);
        textId = findViewById(R.id.secondLayoutId);
        listView = findViewById(R.id.progressListView);
        textName = findViewById(R.id.secondLayoutName);
        textRemain = findViewById(R.id.remainFeed);

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

    public boolean fillCheck(EditText editText) {
        Log.d(LOG_TAG, "체크하기");

        if (editText.getText().toString().length() != 0) {
            return true;
        } else {
            return false;
        }
    }

    public void startButtonOnClick(View view) {

        if ((fillCheck(editTotalFeed) && fillCheck(editTime))) {

            feed = Integer.parseInt(editTotalFeed.getText().toString());
            duration = Integer.parseInt(editTime.getText().toString());

            scheduler.setFeed(feed);
            scheduler.setDuration(duration);
            runScheduler();

        } else {
            if (!fillCheck(editTotalFeed)) {
                Toast.makeText(SecondActivity.this, "먹이 양을 입력해주세요!", Toast.LENGTH_SHORT).show();
            }
            if (!fillCheck(editTime)) {
                Toast.makeText(SecondActivity.this, "끼니시간을 입력해주세요!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void showProgress(int icon, String name, int feed) {

        adapter.addItem(icon, name, feed);

        Message msg = handler.obtainMessage();
        handler.sendMessage(msg);
    }

    //못먹은 동물 표시
    public void showAnimal(int icon, String name) {
        adapter.addItem(icon, name);

        Message msg = handler.obtainMessage();
        handler.sendMessage(msg);
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
            listView.smoothScrollToPosition(adapter.getCount()-1);
            adapter.notifyDataSetChanged();
        }
    };

}
