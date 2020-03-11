package com.example.app0121_2.Objs.Animal;

import com.example.app0121_2.Objs.Animal.Animal;
import com.example.app0121_2.R;

import java.io.Serializable;

public class Sparrow extends Animal  {

    public Sparrow() {
        setName("참새");
        setFeedVolume(50);
        setIcon(R.drawable.icon_bird);
        setActivity("fly, walk");
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
