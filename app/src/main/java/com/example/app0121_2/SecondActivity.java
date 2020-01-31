package com.example.app0121_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {
    private static final String tag="SecondActivity";

    private TextView textId;
    private TextView textName;
    private TextView textTotalFeed;
    private EditText editTextTotalFeed;
    private EditText editTextTime;
    private int totalFeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);





        textId=findViewById(R.id.secondLayoutId);
        textName=findViewById(R.id.secondLayoutName);
        textTotalFeed=findViewById(R.id.totalfeed);

        Intent intent = getIntent();
        Person person =(Person) intent.getSerializableExtra("person");

        textId.setText("["+person.id+"]");
        textName.setText(person.name);





    }


    public boolean fillCheck(EditText editText) {

        if (editText.getText().toString().length() != 0) {
            return true;
        }else{
            return false;
        }
    }


    public void startButtonOnClick(View view){


        editTextTotalFeed=findViewById(R.id.feed_edittext);     //먹이양 edittext
        editTextTime=findViewById(R.id.time_edittext);          //끼니시간 edittext

        totalFeed=Integer.parseInt(editTextTotalFeed.getText().toString());
        textTotalFeed.setText(totalFeed+"개");

        if((fillCheck(editTextTotalFeed) && fillCheck(editTextTime))) {



            if(totalFeed<0){
                Toast.makeText(this,getString(R.string.nofeet_text),Toast.LENGTH_SHORT).show();
            }




        }else{
            Log.d(tag,"먹이양, 끼니시간 입력");
        }



    }
}
