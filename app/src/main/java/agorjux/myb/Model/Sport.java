package agorjux.myb.Model;

import java.util.ArrayList;

/**
 * Created by agorjux on 18/09/16.
 */
public class Sport {

    String name;
    // Color ??

    public Sport(String name){
        this.name = name;
    }

    public static ArrayList<Sport> getAllSports(){
        ArrayList<Sport> sports = new ArrayList<>();

        // Todo : get data from webservice using getSports method
        return sports;
    }
}
