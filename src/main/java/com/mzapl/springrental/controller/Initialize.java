package com.mzapl.springrental.controller;

import com.mzapl.springrental.model.Archetype;
import com.mzapl.springrental.model.Customer;
import com.mzapl.springrental.model.Rental;
import com.mzapl.springrental.model.Unit;
import com.mzapl.springrental.repository.ArchetypeRepository;
import com.mzapl.springrental.service.ArchetypeService;
import com.mzapl.springrental.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping()
public class Initialize {
    @Autowired
    private final ArchetypeService archetypeService;

    @Autowired
    private final UnitService unitService;

    public Initialize(ArchetypeService archetypeService, UnitService unitService) {
        this.archetypeService = archetypeService;
        this.unitService = unitService;
    }

//    @GetMapping
//    ResponseEntity<String> init(){
//        Archetype archetype = new Archetype("Bosch", "MOM911", 60, 120);
//        Archetype archetype1 = new Archetype("Kitchen Aid", "Stand mixer one", 70, 140);
//        Unit unit = new Unit(archetype);
//        Unit unit1 = new Unit(archetype1);
//
//        Customer customer = new Customer("Jan", "Kowalski", "kowalski@wp.pl");
//        Rental rental = new Rental(customer, LocalDateTime.now());
//
//        archetypeService.save(archetype);
//        archetypeService.save(archetype1);
//        unitService.save(unit);
//        unitService.save(unit1);
//
//        return ResponseEntity.ok(archetype.toString());
//    }

}
