package com.example.app0121_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String tag="MainActivity";

    public static Context mContext;

    Person person = new Person();
    //오브젝트는 json으로 변환하고 다시 받아서 변환
    //id myID = new id(getApplicationContext());
    id myID = new id();
    name myName=new name();
    position myPos=new position();
    savebox my_saveCheckBox=new savebox();

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=this;

        EditText id = findViewById(R.id.id_editText);
        EditText name = findViewById(R.id.name_editText);
        EditText pos = findViewById(R.id.position_editText);
        TextView title = findViewById(R.id.title);
        CheckBox saveCheckBox = findViewById(R.id.save_checkBox);

        //타이틀 색상 변경
        String s_title=title.getText().toString();

        Spannable spannable=new SpannableString(s_title);
        spannable.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.c_text)),0,1,spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        title.setText(spannable,TextView.BufferType.SPANNABLE);

        //저장된 정보 표시
        myID.setEditText(id);
        myName.setEditText(name);
        myPos.setEditText(pos);
        my_saveCheckBox.setChecked(saveCheckBox);

    }

    public boolean fillCheck(EditText editText) {
        Log.d(tag, "체크하기");

            if (editText.getText().toString().length() != 0) {
                return true;
            }else{
                return false;
        }
    }

    public void cancelMessage(View view){
        Toast.makeText(this, getString(R.string.cancel_text), Toast.LENGTH_SHORT).show();
        finish();

    }

    public void okMessage(View view) {
        CheckBox saveCheckBox = findViewById(R.id.save_checkBox);

        EditText id = findViewById(R.id.id_editText);
        EditText name = findViewById(R.id.name_editText);
        EditText pos = findViewById(R.id.position_editText);

        if((fillCheck(id) && fillCheck(name) && fillCheck(pos))) {

            Log.d(tag, "다 채워짐");

            if (saveCheckBox.isChecked()) {

                myID.saveEditText(id);
                myName.saveEditText(name);
                myPos.saveEditText(pos);
                my_saveCheckBox.saveChecked(saveCheckBox);

                //Log.d(tag,"사번:"+s_getData(key1));
                //Log.d(tag,"이름:"+s_getData(key2));
                //Log.d(tag,"직책:"+s_getData(key3));

                Toast.makeText(this, getString(R.string.save_text), Toast.LENGTH_SHORT).show();
                finish();

            } else {
                Info.removeData(mContext);

                Toast.makeText(this, getString(R.string.nsave_text), Toast.LENGTH_SHORT).show();
                finish();

            }
        }

    }
}





