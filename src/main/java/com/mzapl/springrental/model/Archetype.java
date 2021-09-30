package com.mzapl.springrental.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Archetype {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String make, model, description;
    double fee, deposit;
    double weight;


    public Archetype(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public Archetype(String make, String model, double fee, double deposit) {
        this.make = make;
        this.model = model;
        this.fee = fee;
        this.deposit = deposit;
    }

    public Archetype() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Archetype{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", description='" + description + '\'' +
                ", fee=" + fee +
                ", deposit=" + deposit +
                ", weight=" + weight +
                '}';
    }
}
