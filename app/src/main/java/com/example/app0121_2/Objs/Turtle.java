package com.example.app0121_2.Objs;

import com.example.app0121_2.R;

public class Turtle extends Animal {

    public Turtle() {
        setName("거북이");
        setFeedVolume(250);
        setIcon(R.drawable.icon_turtle);
    }

    @Override
    public void move() {

    }

    public void swim() {
        move();
    }

    public void crawl(){
        move();
    }
}
