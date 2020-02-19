package com.example.app0121_2.Objs;

import com.example.app0121_2.R;

public class Cat extends Animal {

    public Cat() {
        setName("고양이");
        setFeedVolume(150);
        setIcon(R.drawable.icon_cat);

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
