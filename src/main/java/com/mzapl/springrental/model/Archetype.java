package com.mzapl.springrental.model;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Entity
public class Archetype {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String make, model, description;
    double fee, deposit;
    double weight;

    @OneToMany
    private List<Unit> units = Collections.emptyList();

    public List<Unit> getUnits() {
        return units;
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
