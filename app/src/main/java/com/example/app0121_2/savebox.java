package com.example.app0121_2;

import android.widget.CheckBox;
import android.widget.EditText;

public class savebox {
    public static final String key4="key4";

    public void setChecked(CheckBox checkBox){
        checkBox.setChecked(info.b_getData(MainActivity.mContext,key4));
    }

    public void saveChecked(CheckBox checkBox){
        info.b_saveData(MainActivity.mContext,key4,checkBox);
    }
}
