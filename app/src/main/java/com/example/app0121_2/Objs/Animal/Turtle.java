package com.example.app0121_2.Objs.Animal;

import com.example.app0121_2.Objs.Animal.Animal;
import com.example.app0121_2.R;

import java.io.Serializable;

public class Turtle extends Animal  {

    public Turtle() {
        setName("거북이");
        setFeedVolume(250);
        setIcon(R.drawable.icon_turtle);
        setActivity("swim, crawl");
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
