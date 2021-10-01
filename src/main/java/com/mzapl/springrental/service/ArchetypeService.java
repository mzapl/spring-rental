package com.mzapl.springrental.service;

import com.mzapl.springrental.model.Archetype;
import com.mzapl.springrental.repository.ArchetypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ArchetypeService {
    @Autowired
    private final ArchetypeRepository archetypeRepository;

    public ArchetypeService(ArchetypeRepository archetypeRepository) {
        this.archetypeRepository = archetypeRepository;
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
}
