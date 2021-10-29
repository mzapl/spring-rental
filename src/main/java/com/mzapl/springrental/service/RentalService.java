package com.mzapl.springrental.service;

import com.mzapl.springrental.model.Rental;
import com.mzapl.springrental.repository.RentalRepository;
import com.mzapl.springrental.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RentalService {
    RentalRepository rentalRepository;
    UnitRepository unitRepository;

    @Autowired
    public RentalService(RentalRepository rentalRepository, UnitRepository unitRepository) {
        this.rentalRepository = rentalRepository;
        this.unitRepository = unitRepository;
    }

    //new rental means also start of the rental time
    public void add(Rental rental){
        rental.setOpen(true);
        rental.setRentalDate(LocalDateTime.now());
        rentalRepository.save(rental);
    }

    //end of the rental means summing out the amounts, closing the rental and putting in the return date
    public void end(Rental rental){
        rental.setOpen(false);
        rental.setReturnDate(LocalDateTime.now());
        rentalRepository.save(rental);
    }
}
