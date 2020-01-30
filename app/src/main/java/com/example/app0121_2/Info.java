package com.example.app0121_2;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class Info {
    public static final String PREFERENCE="com.example.app0121_2";
    private static final String tag="Info";

    private static SharedPreferences getPreferences(Context context){
        return context.getSharedPreferences(PREFERENCE,Context.MODE_PRIVATE);
    }

    //오버로드

    public static void stringSave(Context context,String key, String s){
        SharedPreferences pref=getPreferences(context);
        SharedPreferences.Editor editor=pref.edit();
        editor.putString(key,s);
        editor.commit();

        Log.d(tag,"text 데이터 저장");

    }


    public static void boolSave(Context context,String key, CheckBox checkBox){
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

    public static String stringGetData(Context context,String key){
        SharedPreferences pref=getPreferences(context);
        return pref.getString(key,"");
    }

    public static Boolean boolGetData(Context context,String key){
        SharedPreferences pref=getPreferences(context);
        return pref.getBoolean(key,false);

    }


}
