package com.example.hosi.ncu_news;

/**
 * Created by HOSI on 2018/3/24.
 */

public class Activity {
    private int id; //活動id
    private int time; //活動時間
    private String type; //活動類別
    private String title; //活動標題

    public Activity(){
        super();
    }

    public Activity(int id,int time,String type,String title){
        super();
        this.id = id;
        this.time = time;
        this.type = type;
        this.title = title;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getTime(){
        return time;
    }

    public void setTime(int time){
        this.time = time;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }
}
