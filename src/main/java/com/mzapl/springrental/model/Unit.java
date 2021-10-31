package com.mzapl.springrental.model;

import javax.persistence.*;

@Entity
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id;

    @ManyToOne
    Archetype archetype;

    boolean available = true;
    String serialNo;

    public Unit() {
    }

    public Unit(String serialNo) {
        available = true;
        this.serialNo = serialNo;
    }

    public Unit(Archetype archetype) {
        available = true;
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
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
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
                ", isAvailable=" + available +
                ", serialNo='" + serialNo + '\'' +
                '}';
    }
}
