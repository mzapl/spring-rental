package com.mzapl.springrental.service;

import com.mzapl.springrental.model.Archetype;
import com.mzapl.springrental.model.Unit;
import com.mzapl.springrental.repository.ArchetypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class ArchetypeService {

    private final ArchetypeRepository archetypeRepository;

    @Autowired
    public ArchetypeService(ArchetypeRepository archetypeRepository) {
        this.archetypeRepository = archetypeRepository;
    }

    public Optional<Archetype> find(Long id){
        return archetypeRepository.findById(id);
    }

    public void save(Archetype archetype){
        archetypeRepository.save(archetype);
    }

    public void saveAll(List<Archetype> archetypes){
        archetypeRepository.saveAll(archetypes);
    }

    public void remove(Long id){
        archetypeRepository.deleteById(id);
    }

    public void addUnit(Unit unit){
        Optional<Archetype> archetype = find(unit.getArchetype().getId());
        if(archetype.isPresent()){
            archetype.get().getUnits().add(unit);
            save(archetype.get());
        }
    }

    public void setAvailability(Archetype archetype, int amount){
        archetype.setAvailable(amount);
        save(archetype);
    }

    public void checkAvailability(Long id){
        if(find(id).isPresent()){
            Archetype archetype = find(id).get();
            List<Boolean> available = archetype.getUnits().stream().map(unit -> unit.isAvailable()).filter(Predicate.isEqual(true)).collect(Collectors.toList());
            setAvailability(archetype, available.size());
        }
    }
}