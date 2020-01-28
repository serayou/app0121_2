package com.example.app0121_2;

import android.widget.EditText;

public class position {
    public static final String key3="key3";

    public void setEditText(EditText editText){
        editText.setText(info.s_getData(MainActivity.mContext,key3));
    }

    public void saveEditText(EditText editText){
        info.s_saveData(MainActivity.mContext,key3,editText);
    }
}
