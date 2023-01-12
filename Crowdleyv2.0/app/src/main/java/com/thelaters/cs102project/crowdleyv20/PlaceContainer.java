package com.thelaters.cs102project.crowdleyv20;

import java.util.ArrayList;

/**
 * This class holds bunch of places in it
 * @authors Selim Ozcan and Mehmet Sanisoglu
 * @date 11-May-17
 */

public class PlaceContainer {
    private ArrayList<Building> places;
    private int number;

    public PlaceContainer() {

        places = new ArrayList<Building>();
        number = 0;
        Building a = new Building("A Building", "08.00", 15);
        Building b = new Building("B Building", "08.00", 12);
        Building cafe_in = new Building("Cafe In", "08.00",7);
        //Building caffeteria = new Building("Cafferteria","12.00/17.00" , 15);
        Building coffee_break = new Building("Coffee Break", "08.00", 3);
        Building ea = new Building("EA Building", "09.00", 15);
        Building ee = new Building("EE Building", "09.00", 13);
        Building fc = new Building("FC Building", "09.00", 10);
        Building ff = new Building("FF Building", "09.00", 12);
        Building g = new Building("G Building", "10.00", 15);
        Building h = new Building("H Building", "08.00", 9 );
        Building library = new Building("Library", "08.00", 13);
        Building ma = new Building("MA Building", "10.00", 8);
        Building meteksan = new Building("Meteksan Market", "10.00", 6);
        Building sa = new Building("SA Building", "10.00", 12);
        Building sb = new Building("SB Building", "08.00", 8);
        Building speed = new Building("Speed Cafe", "08.00", 7);
        Building sports = new Building("Sports Hall", "08.00", 5);
        //Building starbucks = new Building ("Starbucks", "08.00", 3);
        Building v = new Building("V Building", "12.00", 10);

        places.add(a);
        places.add(b);
        places.add(cafe_in);
        //place.add(caffeteria);
        places.add(coffee_break);
        places.add(ea);
        places.add(ee);
        places.add(fc);
        places.add(ff);
        places.add(g);
        places.add(h);
        places.add(library);
        places.add(ma);
        places.add(meteksan);
        places.add(sa);
        places.add(sb);
        places.add(speed);
        places.add(sports);
        places.add(v);
    }


    public Building compareBuilding(String s) {

        for (int i = 0; i < places.size(); i++) {
            number++;
            if ((places.get(i)).getBuildingName().equals(s)) {
                return places.get(i);
            }
        }
        return null;
    }


    public int getNumber() {
        int ret = number - 1;
        number = 0;
        return ret;
    }

    public Building getPlace(int i){
        return places.get(i);

    }
}