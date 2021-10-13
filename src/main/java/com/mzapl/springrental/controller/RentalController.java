package com.mzapl.springrental.controller;

import com.mzapl.springrental.model.Rental;
import com.mzapl.springrental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rental/")
public class RentalController {
    @Autowired
    RentalService rentalService;

    @PostMapping("add")
    void add(Rental rental){
        rentalService.add(rental);
    }
}
