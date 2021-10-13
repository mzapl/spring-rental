package com.mzapl.springrental.service;

import com.mzapl.springrental.model.Rental;
import com.mzapl.springrental.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalService {
    RentalRepository rentalRepository;

    @Autowired
    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    public void add(Rental rental){
        rentalRepository.save(rental);
    }
}
