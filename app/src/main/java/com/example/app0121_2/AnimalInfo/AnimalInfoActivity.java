package com.example.app0121_2.AnimalInfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app0121_2.Objs.Animal.Animal;
import com.example.app0121_2.Objs.Person;
import com.example.app0121_2.Objs.Tom;
import com.example.app0121_2.R;

public class AnimalInfoActivity extends AppCompatActivity {
    private final String LOG_TAG = "AnimalInfoActivity";
    public static Context mContext;

    private ViewPager viewPager;
    private AnimalInfoAdapter pagerAdapter;

    private ImageButton nextButton;
    private ImageButton preButton;
    private TextView animalName;


    public int catnowfeeds=0;
    public int birdnowfeeds=0;
    public int turtlenowfeeds=0;

    public Tom tom=new Tom();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_info);

        Intent intent = getIntent();
        catnowfeeds = intent.getIntExtra("cat",0);
        birdnowfeeds = intent.getIntExtra("bird",0);
        turtlenowfeeds = intent.getIntExtra("turtle",0);

        mContext = this;

        pagerAdapter = new AnimalInfoAdapter(getSupportFragmentManager());

        nextButton = (ImageButton) findViewById(R.id.animalInfo_next_imageButton);
        preButton = (ImageButton) findViewById(R.id.animalInfo_pre_imageButton);
        animalName = (TextView) findViewById(R.id.animalInfo_name);
        viewPager = (ViewPager) findViewById(R.id.aniamlInfo_ViewPager);

        viewPager.addOnPageChangeListener(mPageChangeListener);
        viewPager.setAdapter(pagerAdapter);

        animalName.setText(tom.cat.getName());

        pagerButton();

    }

    public Fragment toFrag(int page){
        AnimalInfoFragment fragment=new AnimalInfoFragment(page);
        Bundle args=new Bundle();

        args.putInt("cat",catnowfeeds);
        args.putInt("bird",birdnowfeeds);
        args.putInt("turtle",turtlenowfeeds);

        fragment.setArguments(args);

        return fragment;

    }

    public ViewPager.OnPageChangeListener mPageChangeListener = new ViewPager.OnPageChangeListener()
    {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
        {
        }

        @Override
        public void onPageSelected(int position)
        {
            if(position == 0){
                animalName.setText(tom.cat.getName());
            }
            if(position == 1){
                animalName.setText(tom.sparrow.getName());
            }
            if(position == 2){
                animalName.setText(tom.turtle.getName());
            }
        }

        @Override
        public void onPageScrollStateChanged(int state)
        {
        }
    };


    public void pagerButton(){
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pagerAdapter.getItem(getItem(+1)) != null) {
                    viewPager.setCurrentItem(getItem(+1), true);
                } else {
                    Toast.makeText(AnimalInfoActivity.this, "표시할 내용이 없습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        preButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (pagerAdapter.getItem(getItem(-1)) != null) {
                    viewPager.setCurrentItem(getItem(-1), true);
                } else {
                    Toast.makeText(AnimalInfoActivity.this, "표시할 내용이 없습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }
}
