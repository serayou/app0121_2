package com.example.app0121_2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app0121_2.Objs.Animal;
import com.example.app0121_2.Objs.Tom;
import com.example.app0121_2.scheduler.FeedScheduler;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import static java.sql.Types.NULL;

public class SecondActivity extends AppCompatActivity {
    private static final String tag = "SecondActivity";

    private TextView textId;
    private TextView textName;

    private EditText editTotalFeed;  //입력 먹이양
    private EditText editTime;       //입력 끼니시간

    private FeedScheduler scheduler;

    int feed;
    int duration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Animal.InitAnimal(this);

        initLayout();
        initScheduler();

        Intent intent = getIntent();
        Person person = (Person) intent.getSerializableExtra("person");

        textId.setText("[" + person.id + "]");
        textName.setText(person.name);

    }

    private void initLayout() {
        editTotalFeed = (EditText) findViewById(R.id.feed_edittext);
        editTime = (EditText) findViewById(R.id.time_edittext);
        textId = findViewById(R.id.secondLayoutId);
        textName = findViewById(R.id.secondLayoutName);

    }

    private void initScheduler() {
        scheduler = new FeedScheduler();
        scheduler.setManager(new Tom());
        scheduler.setFeed(10000);
        scheduler.setDuration(1000);
    }

    private void runScheduler() {
        scheduler.startScheduleToFeed();
    }

    public boolean fillCheck(EditText editText) {
        Log.d(tag, "체크하기");

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

}
