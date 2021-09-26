package com.mzapl.springrental.model;

public class Archetype {

    String make, model, description;
    double fee, deposit;
    double weight;

    public Archetype(String make, String model, double fee, double deposit) {
        this.make = make;
        this.model = model;
        this.fee = fee;
        this.deposit = deposit;
    }
}
