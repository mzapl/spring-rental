package com.mzapl.springrental.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;

@Entity
public class Unit {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id;

    boolean isAvailable;
    @OneToOne
    Archetype archetype;

//    ArrayList<Rental> rentals;


    public Unit() {
    }

    public Unit(Archetype archetype) {
        isAvailable = true;
        this.archetype = archetype;
    }
}
