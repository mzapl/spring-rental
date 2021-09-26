package com.mzapl.springrental.model;

import java.util.ArrayList;

public class Customer {
    private String name, surname, email;

    private float discount = 0;
    //    ArrayList<Rental> rentals;


    public Customer(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
}
