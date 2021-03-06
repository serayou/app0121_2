package com.example.app0121_2.Objs;

import android.util.Log;

public class Tom {

    private final String LOG_TAG = "Tom";

    private int feed = 0;
    private Cat cat = new Cat();
    private Sparrow sparrow = new Sparrow();
    private Turtle turtle = new Turtle();

    public Tom() {
    }

    public void saveFeed(int feed) {
        this.feed = feed;
        Log.i(LOG_TAG, String.format("Tom이 먹이를 %d 그램 받았습니다.", feed));
    }

    public int getFeed() {
        return this.feed;
    }

    public Animal feedToPets() {
        Log.i(LOG_TAG, "Tom이 먹이를 줍니다.");
        if(checkRemainNextFeed(cat) == false) {
            return cat;
        }
        else if(checkRemainNextFeed(sparrow) == false) {
            return sparrow;
        }
        else if(checkRemainNextFeed(turtle) == false) {
            return turtle;
        }
        else {
            return null;
        }
    }


    private boolean checkRemainNextFeed(Animal animal) {
        int remainFeed =  animal.eat(feed); //동물이 먹고 남은 양을 남아있는것(feed)과 비교
        if(feed == remainFeed) {
            return false;
        }
        else {
            feed = remainFeed;
            return true;    //ture면 다음동물로 넘어감
        }

    }
}
