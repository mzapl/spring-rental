package com.mzapl.springrental.service;

import com.mzapl.springrental.model.Archetype;
import com.mzapl.springrental.model.Unit;
import com.mzapl.springrental.repository.ArchetypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ArchetypeService {
    @Autowired
    private final ArchetypeRepository archetypeRepository;

    public ArchetypeService(ArchetypeRepository archetypeRepository) {
        this.archetypeRepository = archetypeRepository;
    }

    public Optional<Archetype> find(Long id){
        return archetypeRepository.findById(id);
    }

    public void save(Archetype archetype){
        archetypeRepository.save(archetype);
    }

    public void saveAll(ArrayList<Archetype> archetypes){
        archetypeRepository.saveAll(archetypes);
    }

    public void remove(Long id){
        archetypeRepository.deleteById(id);
    }

    public void addUnit(Unit unit){
        Optional<Archetype> archetype = find(unit.getArchetype().getId());
        if(archetype.isPresent()){
            archetype.get().getUnits().add(unit);
        }
    }
}
