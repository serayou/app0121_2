package com.example.app0121_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {
    private static final String tag="SecondActivity";

    TextView textId;
    TextView textName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textId=findViewById(R.id.secondLayoutId);
        textName=findViewById(R.id.secondLayoutName);

        Intent intent = getIntent();
        Person person =(Person) intent.getSerializableExtra("person");

        Log.d(tag,"user 사번 : "+person.id);
        Log.d(tag,"user 이름 : "+person.name);

        textId.setText("["+person.id+"]");
        textName.setText(person.name);



    }
}
