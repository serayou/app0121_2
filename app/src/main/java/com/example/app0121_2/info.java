package com.example.app0121_2;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class info {
    public static final String PREFERENCE="com.example.app0121_2";
    private static final String tag="info";

    private static SharedPreferences getPreferences(Context context){
        return context.getSharedPreferences(PREFERENCE,Context.MODE_PRIVATE);
    }

    public static void s_saveData(Context context,String key, EditText editText){
        SharedPreferences pref=getPreferences(context);
        SharedPreferences.Editor editor=pref.edit();
        editor.putString(key,editText.getText().toString());
        editor.commit();

        Log.d(tag,"text 데이터 저장");

    }
    public static void b_saveData(Context context,String key, CheckBox checkBox){
        SharedPreferences pref=getPreferences(context);
        SharedPreferences.Editor editor=pref.edit();
        editor.putBoolean(key,checkBox.isChecked());
        editor.commit();

        Log.d(tag,"checkbox 데이터 저장");

    }

    public static void removeData(Context context){
        SharedPreferences pref=getPreferences(context);
        SharedPreferences.Editor editor=pref.edit();
        editor.clear();
        editor.commit();
    }

    public static String s_getData(Context context,String key){
        SharedPreferences pref=getPreferences(context);
        return pref.getString(key,"");
    }

    public static Boolean b_getData(Context context,String key){
        SharedPreferences pref=getPreferences(context);
        return pref.getBoolean(key,false);

    }


}
