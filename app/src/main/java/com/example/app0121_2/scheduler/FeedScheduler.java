package com.example.app0121_2.scheduler;

import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app0121_2.Objs.Animal;
import com.example.app0121_2.Objs.Tom;


import static java.lang.Thread.sleep;


public class FeedScheduler extends AppCompatActivity {

    private final String LOG_TAG = "FeedScheduler";

    private Tom tom;
    private int duration = 0;
    private boolean isInterruptOcurred =  false;




    public void setManager(Tom tom) {
        this.tom = tom;
        Log.i(LOG_TAG, "Tom 집사가 선정되었습니다.");
    }

    public void setFeed(int feed) {
        tom.saveFeed(feed);
        Log.i(LOG_TAG,  String.format("먹이가 집사에게  주어졌습니다. 총 %d 그램 입니다.", feed));
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void stopSchedule() {
        isInterruptOcurred = true;
        Log.i(LOG_TAG, "먹이 공급을 중단합니다...");
    }

    public void startScheduleToFeed() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i(LOG_TAG, "먹이 공급을 시작합니다.");
                int remainFeed = 0;
                int dayCount = 0;
                int dayFeedCount = 0;
                int totalFeedCount = 0;
                Animal remainAnimal = null;                                                         //못먹은 동물


                while(true && isInterruptOcurred == false) {
                    if(dayFeedCount % Animal.DAY_FEED_MAX_COUNT == 0) {
                        dayCount++;
                        dayFeedCount = 0;
                    }
                    dayFeedCount++;
                    totalFeedCount++;
                    printProgress(dayCount, dayFeedCount, totalFeedCount);
                    remainAnimal=  tom.feedToPets();

                    if(remainAnimal == null) {
                        try {
                            sleep(duration);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        remainFeed = tom.getFeed();
                        printResult(remainAnimal, remainFeed);
                        break;
                    }
                }

                if(isInterruptOcurred) {
                    isInterruptOcurred = false;
                }
            }
        }).start();

    }



    private void printProgress(int dayCount, int dayFeedCount, int feedCount) {
        Log.i(LOG_TAG, String.format("먹이주기 %d일째, %d번째 끼니...", dayCount, dayFeedCount));
        Log.i(LOG_TAG, String.format("전체 %d번째 끼니...", feedCount));
    }

    private void printResult(Animal animal, int remain) {
        String hungryPet = animal.name;
        Log.i(LOG_TAG, String.format("남은 먹이양 : %d", remain));
        Log.i(LOG_TAG,  "못 먹는 아이 : " + hungryPet);
    }
}
