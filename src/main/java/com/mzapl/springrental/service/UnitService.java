package com.mzapl.springrental.service;

import com.mzapl.springrental.model.Archetype;
import com.mzapl.springrental.model.Unit;
import com.mzapl.springrental.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void deleteById(Long id){
        unitRepository.deleteById(id);
    }

    public Optional<Unit> find(Long id){
        return unitRepository.findById(id);
    }

    public List<Unit> find(Archetype archetype){
        return unitRepository.findAllByArchetype(archetype);
    }

    public List<Unit> findAll(){
        return unitRepository.findAll();
    }



}
