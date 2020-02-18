package com.example.app0121_2;

public class ListviewItem {
    private int type;

    private int icon;
    private String name;
    private int feed;

    public ListviewItem(int icon,String name,int feed){
        this.icon=icon;
        this.name=name;
        this.feed=feed;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFeed() {
        return feed;
    }

    public void setFeed(int feed) {
        this.feed = feed;
    }
}
