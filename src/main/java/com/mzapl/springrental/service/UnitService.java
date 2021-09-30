package com.mzapl.springrental.service;

import com.mzapl.springrental.model.Unit;
import com.mzapl.springrental.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitService {
    @Autowired
    private final UnitRepository unitRepository;

    public UnitService(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    public void save(Unit unit){
        unitRepository.save(unit);
    }
}