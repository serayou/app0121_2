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

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private static final String tag="MainActivity";
    public static final String key1="key1";
    public static Context mContext;

    Person person = new Person();
    JSONObject jsonObject = new JSONObject();
    Savebox my_saveCheckBox=new Savebox();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=this;

        //타이틀 색상 변경
        changeTextColor();

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

        @Override
    protected void onResume() {
        super.onResume();

        EditText id = findViewById(R.id.id_editText);
        EditText name = findViewById(R.id.name_editText);
        EditText pos = findViewById(R.id.position_editText);
        CheckBox saveCheckBox = findViewById(R.id.save_checkBox);

        my_saveCheckBox.setChecked(saveCheckBox);

        if(my_saveCheckBox.isCheck(saveCheckBox) ){

            //저장된 값 띄우기
            Log.d(tag,"checkbox is checked");

            getPerson();

            id.setText(person.id);
            name.setText(person.name);
            pos.setText(person.position);

        }else{

            Log.d(tag,"checkbox is not checked");

        }

    }

    private void getPerson(){

        String personObjString=Info.stringGetData(mContext,key1);

        Gson gson=new Gson();
        person=gson.fromJson(personObjString,Person.class);

        Log.d(tag,"person 사번 :"+person.id+" 이름 : "+person.name+" 직책 : "+person.position);

    }



    public String toJson() {
        EditText id = findViewById(R.id.id_editText);
        EditText name = findViewById(R.id.name_editText);
        EditText pos = findViewById(R.id.position_editText);

        try {
            jsonObject.put("id", person.getId(id));
            jsonObject.put("name", person.getName(name));
            jsonObject.put("position", person.getPosition(pos));

            return jsonObject.toString();

        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }


    public void changeTextColor(){
        TextView title = findViewById(R.id.title);

        String s_title=title.getText().toString();
        Spannable spannable=new SpannableString(s_title);
        spannable.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.c_text)),0,1,spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        title.setText(spannable,TextView.BufferType.SPANNABLE);

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

                Info.stringSave(mContext,key1,toJson());
                my_saveCheckBox.saveChecked(saveCheckBox);

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