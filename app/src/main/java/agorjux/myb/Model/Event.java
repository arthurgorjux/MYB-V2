package agorjux.myb.Model;

import java.text.DateFormat;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by agorjux on 18/09/16.
 */
public class Event {

    int id;
    String title;
    String description;
    String dateEvent;
    long latitude;
    long longitude;
    String sport;
    int people;
    int idUser;

    public Event(int id, String title, String description, String dateEvent, long latitude, long longitude, String sport, int people, int idUser){
        this.id = id;
        this.title = title;
        this.description = description;
        this.dateEvent = dateEvent;
        this.latitude = latitude;
        this.longitude = longitude;
        this.sport = sport;
        this.people = people;
        this.idUser = idUser;
    }

    public Date getFormattedDate(){
        DateFormat formatter ;
        Date date;
        formatter = new SimpleDateFormat("dd-MM-yy hh::mm::ss");
        try {
            return formatter.parse(this.dateEvent);
        } catch (ParseException e) {
            return null;
        }
    }

}
