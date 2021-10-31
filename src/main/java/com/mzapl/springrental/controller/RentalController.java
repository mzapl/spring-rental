package com.mzapl.springrental.controller;

import com.mzapl.springrental.model.Rental;
import com.mzapl.springrental.service.CustomerService;
import com.mzapl.springrental.service.RentalService;
import com.mzapl.springrental.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rental/")
public class RentalController {
    RentalService rentalService;
    CustomerService customerService;
    UnitService unitService;

    @Autowired
    public RentalController(RentalService rentalService, CustomerService customerService, UnitService unitService) {
        this.rentalService = rentalService;
        this.customerService = customerService;
        this.unitService = unitService;
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
