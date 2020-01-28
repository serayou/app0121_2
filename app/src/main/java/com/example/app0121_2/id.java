package com.example.app0121_2;

import android.widget.EditText;

public class id {
    public static final String key1="key1";

    public void setEditText(EditText editText){
        editText.setText(info.s_getData(MainActivity.mContext,key1));
    }

    public void saveEditText(EditText editText){
        info.s_saveData(MainActivity.mContext,key1,editText);
    }



}
