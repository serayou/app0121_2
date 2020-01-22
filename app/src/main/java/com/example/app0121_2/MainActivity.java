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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText id=(EditText)findViewById(R.id.id_editText);
        EditText name=(EditText)findViewById(R.id.name_editText);
        EditText pos=(EditText)findViewById(R.id.position_editText);
        TextView title=(TextView)findViewById(R.id.title);

        id.setText(getData(key1));
        name.setText(getData(key2));
        pos.setText(getData(key3));

        String s_title=title.getText().toString();

        Spannable spannable=new SpannableString(s_title);
        //spannable.setSpan(new ForegroundColorSpan(Color.RED),s_title.length(),s_,spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

    }

    public void saveData(String key,EditText editText){
        SharedPreferences pref=getSharedPreferences(PREFERENCE,MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        editor.putString(key,editText.getText().toString());
        editor.commit();

        Log.d(tag,"데이터 저장");

    }

    public String getData(String key){

        SharedPreferences pref=getSharedPreferences(PREFERENCE,MODE_PRIVATE);
        return pref.getString(key,"");


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
        CheckBox saveCheckBox = (CheckBox) findViewById(R.id.save_checkBox);

        EditText id=(EditText)findViewById(R.id.id_editText);
        EditText name=(EditText)findViewById(R.id.name_editText);
        EditText pos=(EditText)findViewById(R.id.position_editText);

        if((fillCheck(id) && fillCheck(name) && fillCheck(pos))) {

            Log.d(tag, "다 채워짐");

            if (saveCheckBox.isChecked()) {

                saveData(key1,id);
                saveData(key2,name);
                saveData(key3,pos);

                Log.d(tag,"사번:"+getData(key1));
                Log.d(tag,"이름:"+getData(key2));
                Log.d(tag,"직책:"+getData(key3));

                Toast toast = Toast.makeText(this, "저장하였습니다.", Toast.LENGTH_SHORT);
                toast.show();
                finish();

            } else {

                Toast toast = Toast.makeText(this, "저장하지 않고 종료합니다.", Toast.LENGTH_SHORT);
                toast.show();
                finish();

            }
        }

    }
}
