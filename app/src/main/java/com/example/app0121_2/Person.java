package com.example.app0121_2;

import android.util.Log;
import android.widget.EditText;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class Person {
    private static final String tag="Person";
    String id;
    String name;
    String position;

    public String getId(EditText editText) {
        id=editText.getText().toString();
        return id;
    }

    public void setId(String id) {
        this.id = id;

    }

    public String getName(EditText editText) {
        name=editText.getText().toString();
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }


    public String getPosition(EditText editText) {
        position=editText.getText().toString();
        return position;
    }

    public void setPosition(String position) {

        this.position = position;
    }



}
