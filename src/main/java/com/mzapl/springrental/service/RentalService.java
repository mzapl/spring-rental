package com.mzapl.springrental.service;

import com.mzapl.springrental.model.Customer;
import com.mzapl.springrental.model.Rental;
import com.mzapl.springrental.model.Unit;
import com.mzapl.springrental.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RentalService {
    private final RentalRepository rentalRepository;
    private final UnitService unitService;

    @Autowired
    public RentalService(RentalRepository rentalRepository, UnitService unitService) {
        this.rentalRepository = rentalRepository;
        this.unitService = unitService;
    }

    //inits a rentalobject for a Customer
    public void init(Customer customer){
        rentalRepository.save(new Rental(customer));
    }

    //new rental means also start of the rental time
    public void start(Rental rental){
        rental.setOpen(true);
        rental.setRentalDate(LocalDateTime.now());
        rentalRepository.save(rental);
    }

    public void addUnit(Long rentalId, Long unitId){
        Optional<Unit> optionalUnit = unitService.find(unitId);
        Optional<Rental> optionalRental = rentalRepository.findById(rentalId);
        if(optionalUnit.isPresent() && optionalRental.isPresent()){
            Unit unit = unitService.find(unitId).get();
            Rental rental = rentalRepository.findById(rentalId).get();
            if(unit.isAvailable()){
                rental.getUnits().add(unit);
                unitService.rentUnit(unit);
                rentalRepository.save(rental);
            }
        }
    }

    public void removeUnit(Long rentalId, Long unitId){
        Optional<Unit> optionalUnit = unitService.find(unitId);
        Optional<Rental> optionalRental = rentalRepository.findById(rentalId);
        if(optionalUnit.isPresent() && optionalRental.isPresent()){
            Unit unit = unitService.find(unitId).get();
            Rental rental = rentalRepository.findById(rentalId).get();
            if(rental.getUnits().contains(unit)){
                rental.getUnits().remove(unit);
                unitService.returnUnit(unit);
                rentalRepository.save(rental);
            }

        }
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
        rentalRepository.save(rental);
    }

    //gets list of units archetypes along with cost of each of them.
    public List<Double> getFees(Rental rental){
        return rental.getUnits().stream().map(unit -> unit.getArchetype().getFee()).collect(Collectors.toList());
    }

    //gets rental period in days
    public int getPeriod(Rental rental){
        Period period = Period.between(rental.getRentalDate().toLocalDate(), rental.getReturnDate().toLocalDate());
        return period.getDays();
    }
}
