package com.example.angusmiller.dream;

/**
 * Created by angusmiller on 3/3/18.
 */

public class Record {
    private String date, duration, period;

    public Record(){
    }

    public Record(String date, String period){
        this.date = date;
        this.duration = "";
        this.period = period;
    }

//    public Record(String date, String duration, String period){
//        this.date = date;
//        this.duration = duration;
//        this.period = period;
//    }

    public void updateRecord(String duration, String period){
        this.duration = duration;
        this.period = this.period + " - " + period;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
}
