package com.mzapl.springrental.controller;

import com.mzapl.springrental.model.Customer;
import com.mzapl.springrental.model.Rental;
import com.mzapl.springrental.model.Unit;
import com.mzapl.springrental.service.CustomerService;
import com.mzapl.springrental.service.RentalService;
import com.mzapl.springrental.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/rental/")
public class RentalController {
    private final RentalService rentalService;
    private final CustomerService customerService;
    private final UnitService unitService;

    @Autowired
    public RentalController(RentalService rentalService, CustomerService customerService, UnitService unitService) {
        this.rentalService = rentalService;
        this.customerService = customerService;
        this.unitService = unitService;
    }

    @PostMapping("init")
    public void init(@RequestBody Customer customer){
        rentalService.init(customer);
    }

    @PostMapping("add-unit")
    public void addUnit(@RequestParam Long rentalId, @RequestParam Long unitId){
        rentalService.addUnit(rentalId, unitId);
    }

    @PostMapping("remove-unit")
    public void removeUnit(@RequestParam Long rentalId, @RequestParam Long unitId){
        rentalService.removeUnit(rentalId, unitId);
    }

    @PostMapping("start")
    public void start(@RequestBody Rental rental){
        customerService.addRental(rental);
        rentalService.start(rental);
    }

    @PostMapping("end")
    public void end(@RequestBody Rental rental){
        rentalService.end(rental);
    }
}