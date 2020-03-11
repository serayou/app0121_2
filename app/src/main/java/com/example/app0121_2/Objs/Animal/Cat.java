package com.example.app0121_2.Objs.Animal;

import com.example.app0121_2.Objs.Animal.Animal;
import com.example.app0121_2.R;

import java.io.Serializable;

public class Cat extends Animal  {

    public Cat() {
        setName("고양이");
        setFeedVolume(150);
        setIcon(R.drawable.icon_cat);
        setActivity("jump, crawl, walk, run");

    }

    @Override
    public void move() {

    }


    public void jump() {
        move();
    }

    public void crawl() {
        move();
    }

    public void walk() {
        move();
    }

    public void run() {
        move();
    }
}
