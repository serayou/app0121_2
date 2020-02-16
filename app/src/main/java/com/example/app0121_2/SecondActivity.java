package com.example.app0121_2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    private static final String tag="SecondActivity";

    ListView listView;


    //static final String[] LIST_MENU = {"LIST1","LIST2","LIST3"};  //listview sample
    String mTitle []={"bird","cat","turtle"};
    int images[]={R.drawable.icon_bird,R.drawable.icon_cat, R.drawable.icon_turtle};


    private TextView textId;
    private TextView textName;
    private TextView textremainedFeed;
    private EditText editTextTotalFeed;
    private EditText editTextTime;
    private int totalFeed;//입력하는 먹이양
    private int remainedFeed;//남은 먹이양;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        remainedFeed=637000;





//////listview sample
//
//        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,LIST_MENU);
//        ListView listView=findViewById(R.id.progreeListView);
//        listView.setAdapter(adapter);
//
//
//        //List<String> list = new ArrayList<>();
//
//
//
//
//////



        textId=findViewById(R.id.secondLayoutId);
        textName=findViewById(R.id.secondLayoutName);
        textremainedFeed=findViewById(R.id.remainedFeed);

        Intent intent = getIntent();
        Person person =(Person) intent.getSerializableExtra("person");

        textId.setText("["+person.id+"]");
        textName.setText(person.name);





    }

    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        String rTitle[];
        int rImgs[];

        MyAdapter(Context c, String title[], int imgs[]){
            super(c, R.layout.item2, R.id.item2_textView,title);
            this.context=c;
            this.rTitle=title;
            this.rImgs=imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater=(LayoutInflater)getApplicationContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View item2=layoutInflater.inflate(R.layout.item2,parent,false);
            ImageView images=item2.findViewById(R.id.item2_imageView);
            TextView myTitle=item2.findViewById(R.id.item2_textView);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);




            return item2;
        }
    }


    public boolean fillCheck(EditText editText) {

        if (editText.getText().toString().length() != 0) {
            return true;
        }else{
            return false;
        }
    }


    public void startButtonOnClick(View view){


        editTextTotalFeed=findViewById(R.id.feed_edittext);     //먹이양 edittext
        editTextTime=findViewById(R.id.time_edittext);          //끼니시간 edittext

        totalFeed=Integer.parseInt(editTextTotalFeed.getText().toString());


        if((fillCheck(editTextTotalFeed) && fillCheck(editTextTime))) {
            remainedFeed=remainedFeed-totalFeed;
            textremainedFeed.setText(remainedFeed+"개");


            if(totalFeed<0){
                Toast.makeText(this,getString(R.string.nofeet_text),Toast.LENGTH_SHORT).show();
            }

            listView=findViewById(R.id.progressListView);

            MyAdapter adapter=new MyAdapter(this, mTitle,images);
            listView.setAdapter(adapter);




        }else{
            Log.d(tag,"먹이양, 끼니시간 입력");
        }



    }
}
