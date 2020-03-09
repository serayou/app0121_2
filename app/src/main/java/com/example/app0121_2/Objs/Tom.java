package com.example.app0121_2.Objs;

import android.util.Log;

import com.example.app0121_2.Objs.Animal.Animal;
import com.example.app0121_2.Objs.Animal.Cat;
import com.example.app0121_2.Objs.Animal.Sparrow;
import com.example.app0121_2.Objs.Animal.Turtle;

public class Tom {

    private final String LOG_TAG = "Tom";

    private int feed = 0;
    public Cat cat = new Cat();
    public Sparrow sparrow = new Sparrow();
    public Turtle turtle = new Turtle();

    public Tom() {
    }


    public void saveFeed(int feed) {
        this.feed = feed;
        Log.i(LOG_TAG, String.format("Tom이 먹이를 %d 그램 받았습니다.", feed));
    }

    public int getFeed() {

        return this.feed;
    }

    public Animal feedToPets(int flag) {
        Log.i(LOG_TAG, "Tom이 먹이를 줍니다.");
        if(checkRemainNextFeed(cat,flag) == false) {
            return cat;
        }
        else if(checkRemainNextFeed(sparrow,flag) == false) {
            return sparrow;
        }
        else if(checkRemainNextFeed(turtle,flag) == false) {
            return turtle;
        }
        else {
            return null;
        }
    }


    private boolean checkRemainNextFeed(Animal animal,int flag) {
        int remainFeed =  animal.eat(feed,flag);
        if(feed == remainFeed) {
            return false;
        }
        else {
            feed = remainFeed;
            return true;
        }

    }
}
