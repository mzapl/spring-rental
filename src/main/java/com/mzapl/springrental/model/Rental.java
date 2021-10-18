package com.mzapl.springrental.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    Customer customer;

    @OneToMany
    List<Unit> units = Collections.emptyList();
    double amount;
    double depositAmount;

    LocalDateTime rentalDate, returnDate;
    boolean isOpen;

    public Rental() {
    }

    public Rental(Customer customer) {
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public LocalDateTime getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDateTime rentalDate) {
        this.rentalDate = rentalDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", customer=" + customer +
                ", units=" + units +
                ", amount=" + amount +
                ", depositAmount=" + depositAmount +
                ", rentalDate=" + rentalDate +
                ", returnDate=" + returnDate +
                ", isOpen=" + isOpen +
                '}';
    }
}
