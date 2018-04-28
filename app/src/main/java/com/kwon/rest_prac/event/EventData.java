package com.kwon.rest_prac.event;

/**
 * Created by niceguy on 2018-03-27.
 */

public class EventData {
    int eventnum;
    String clubname;
    String contents;
    String date;
    String time;
    String location;

    public EventData(int eventnumnum, String clubname, String contents, String date, String time, String location){
        this.eventnum = eventnumnum;
        this.clubname = clubname;
        this.contents = contents;
        this.date = date;
        this.time = time;
        this.location = location;
    }
}