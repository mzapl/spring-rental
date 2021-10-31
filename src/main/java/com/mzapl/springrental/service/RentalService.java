package com.mzapl.springrental.service;

import com.mzapl.springrental.model.Rental;
import com.mzapl.springrental.repository.RentalRepository;
import com.mzapl.springrental.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalService {
    private final RentalRepository rentalRepository;
    private final UnitRepository unitRepository;

    @Autowired
    public RentalService(RentalRepository rentalRepository, UnitRepository unitRepository) {
        this.rentalRepository = rentalRepository;
        this.unitRepository = unitRepository;
    }

    //new rental means also start of the rental time
    public void start(Rental rental){
        rental.setOpen(true);
        rental.setRentalDate(LocalDateTime.now());
        rentalRepository.save(rental);
    }

    //end of the rental means summing out the amounts, closing the rental and putting in the return date
    public void end(Rental rental){
        rental.setOpen(false);
        rental.setReturnDate(LocalDateTime.now());
        sumUp(rental);
        rentalRepository.save(rental);
    }

    public void sumUp(Rental rental){
        double fees = getFees(rental).stream().mapToDouble(value -> value).sum();
        rental.setAmount(fees * getPeriod(rental));
    }

    //gets list of units archetypes along with cost of each of them.
    public List<Double> getFees(Rental rental){
        return rental.getUnits().stream().map(unit -> unit.getArchetype().getFee()).collect(Collectors.toList());
    }

    //gets rental period
    public int getPeriod(Rental rental){
        Period period = Period.between(rental.getRentalDate().toLocalDate(), rental.getReturnDate().toLocalDate());
        return period.getDays();
    }
}
