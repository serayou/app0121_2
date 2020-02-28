package com.example.app0121_2.Objs.Animal;

import com.example.app0121_2.Objs.Animal.Animal;
import com.example.app0121_2.R;

public class Sparrow extends Animal {

    public Sparrow() {

        setName("참새");
        setFeedVolume(50);
        setIcon(R.drawable.icon_bird);
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
