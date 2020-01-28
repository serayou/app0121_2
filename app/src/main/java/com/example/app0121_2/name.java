package com.example.app0121_2;

import android.widget.EditText;

public class name {
    public static final String key2="key2";

    public void setEditText(EditText editText){
        editText.setText(info.s_getData(MainActivity.mContext,key2));
    }

    public void saveEditText(EditText editText){
        info.s_saveData(MainActivity.mContext,key2,editText);
    }
}
