package com.mzapl.springrental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {
    private final UnitService unitService;
    private final ArchetypeService archetypeService;
    private final RentalService rentalService;

    @Autowired
    public StockService(UnitService unitService, ArchetypeService archetypeService, RentalService rentalService) {
        this.unitService = unitService;
        this.archetypeService = archetypeService;
        this.rentalService = rentalService;
    }
}
