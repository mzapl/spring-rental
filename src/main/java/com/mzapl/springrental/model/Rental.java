package com.mzapl.springrental.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Rental {
    Customer customer;
    ArrayList<Unit> units;
    double amount;
    double depositAmount;

    LocalDateTime rentalDate, returnDate;
    boolean isOpen;

    public Rental(Customer customer, LocalDateTime rentalDate) {
        this.customer = customer;
        this.rentalDate = rentalDate;
    }
}
