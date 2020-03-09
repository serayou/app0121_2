package com.example.app0121_2.AnimalInfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.app0121_2.Adapter.AnimalInfoAdapter;
import com.example.app0121_2.R;
import com.example.app0121_2.SecondActivity;

public class AnimalInfoActivity extends AppCompatActivity {
    public static Context mContext;
    private ViewPager viewPager;
    private AnimalInfoAdapter pagerAdapter;
    public ImageButton nextButton;
    public ImageButton preButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_info);

        mContext = this;

        nextButton = (ImageButton) findViewById(R.id.animalInfo_next_imageButton);
        preButton = (ImageButton) findViewById(R.id.animalInfo_pre_imageButton);
        viewPager = (ViewPager) findViewById(R.id.aniamlInfo_ViewPager);

        pagerAdapter = new AnimalInfoAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        pagerButton();


    }


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
