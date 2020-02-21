package com.example.app0121_2;

import android.widget.CheckBox;

public class Savebox {
    public static final String key4="key4";

    public void setChecked(CheckBox checkBox){
        checkBox.setChecked(Info.boolGetData(MainActivity.mContext,key4));
    }

    public void saveChecked(CheckBox checkBox){
        Info.boolSave(MainActivity.mContext,key4,checkBox);
    }

    public boolean isCheck(CheckBox checkBox){

        if(checkBox.isChecked()){
            return true;
        }else{
            return false;
        }

    }
}
