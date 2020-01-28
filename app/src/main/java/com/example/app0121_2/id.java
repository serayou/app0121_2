package com.example.app0121_2;

import android.content.Context;
import android.widget.EditText;

public class id {
    public static final String key1="key1";

//    private Context context;
//
//    public id() {
//    }
//
//    public id(Context context) {
//        this.context = context;
//    }
//
//    public void setContext(Context context) {
//        this.context = context;
//    }

    public void setEditText(EditText editText){
        editText.setText(Info.s_getData(MainActivity.mContext,key1));
    }

    public void saveEditText(EditText editText){
        Info.s_saveData(MainActivity.mContext,key1,editText);
    }



}
