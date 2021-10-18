package com.mzapl.springrental.model;

import javax.persistence.*;

@Entity
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id;

    @ManyToOne
    Archetype archetype;

    boolean isAvailable;
    String serialNo;

//    ArrayList<Rental> rentals;

    public Unit() {
    }

    public Unit(String serialNo) {
        isAvailable = true;
        this.serialNo = serialNo;
    }

    public Unit(Archetype archetype) {
        isAvailable = true;
        this.archetype = archetype;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Archetype getArchetype() {
        return archetype;
    }

    public void setArchetype(Archetype archetype) {
        this.archetype = archetype;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "Id=" + Id +
                ", archetype=" + archetype +
                ", isAvailable=" + isAvailable +
                ", serialNo='" + serialNo + '\'' +
                '}';
    }
}
