package com.mzapl.springrental.model;

import java.util.ArrayList;

public class Unit {

    boolean isAvailable;
    Archetype archetype;

//    ArrayList<Rental> rentals;

    public Unit(Archetype archetype) {
        isAvailable = true;
        this.archetype = archetype;
    }
}
