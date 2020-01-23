package com.example.app0121_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String tag="MainActivity";
    public final String PREFERENCE="com.example.app0121_2";
    public final String key1="key1";
    public final String key2="key2";
    public final String key3="key3";
    public final String key4="key4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText id = findViewById(R.id.id_editText);
        EditText name = findViewById(R.id.name_editText);
        EditText pos = findViewById(R.id.position_editText);
        TextView title = findViewById(R.id.title);
        CheckBox saveCheckBox = findViewById(R.id.save_checkBox);

        id.setText(s_getData(key1));
        name.setText(s_getData(key2));
        pos.setText(s_getData(key3));
        saveCheckBox.setChecked(b_getData(key4));


        //타이틀 색상 변경
        String s_title=title.getText().toString();

        Spannable spannable=new SpannableString(s_title);
        spannable.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.c_text)),0,1,spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        title.setText(spannable,TextView.BufferType.SPANNABLE);

    }

    public void s_saveData(String key,EditText editText){
        SharedPreferences pref=getSharedPreferences(PREFERENCE,MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        editor.putString(key,editText.getText().toString());
        editor.commit();

        Log.d(tag,"데이터 저장");

    }
    public void b_saveData(String key,CheckBox checkBox){
        SharedPreferences pref=getSharedPreferences(PREFERENCE,MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        editor.putBoolean(key,checkBox.isChecked());
        editor.commit();

        Log.d(tag,"데이터 저장");

    }

    public void removeData(){
        SharedPreferences pref=getSharedPreferences(PREFERENCE,MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        editor.clear();
        editor.commit();
    }

    public String s_getData(String key){
        SharedPreferences pref=getSharedPreferences(PREFERENCE,MODE_PRIVATE);
        return pref.getString(key,"");
    }

    public Boolean b_getData(String key){
        SharedPreferences pref=getSharedPreferences(PREFERENCE,MODE_PRIVATE);
        return pref.getBoolean(key,false);
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
        Toast toast= Toast.makeText(this, "취소합니다.", Toast.LENGTH_SHORT);
        toast.show();
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

                s_saveData(key1,id);
                s_saveData(key2,name);
                s_saveData(key3,pos);
                b_saveData(key4,saveCheckBox);


                //Log.d(tag,"사번:"+s_getData(key1));
                //Log.d(tag,"이름:"+s_getData(key2));
                //Log.d(tag,"직책:"+s_getData(key3));

                Toast toast = Toast.makeText(this, "저장하였습니다.", Toast.LENGTH_SHORT);
                toast.show();
                finish();

            } else {
                removeData();

                Toast toast = Toast.makeText(this, "저장하지 않고 종료합니다.", Toast.LENGTH_SHORT);
                toast.show();
                finish();

            }
        }

    }
}





