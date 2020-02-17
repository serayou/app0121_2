package com.example.app0121_2.Objs;

public class Turtle extends Animal {

    public Turtle() {
        setName("거북이");
        setFeedVolume(250);
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
