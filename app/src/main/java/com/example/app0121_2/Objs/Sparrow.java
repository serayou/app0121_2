package com.example.app0121_2.Objs;

public class Sparrow extends Animal {

    public Sparrow() {

        setName("참새");
        setFeedVolume(50);
    }

    @Override
    public void move() {

    }

    public void fly() {
        move();
    }

    public void walk() {
        move();
    }
}
