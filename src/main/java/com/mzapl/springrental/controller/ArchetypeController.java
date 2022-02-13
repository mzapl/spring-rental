package com.mzapl.springrental.controller;

import com.mzapl.springrental.model.Archetype;
import com.mzapl.springrental.service.ArchetypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/archetype/")
public class ArchetypeController {
    private final ArchetypeService archetypeService;

    @Autowired
    public ArchetypeController(ArchetypeService archetypeService) {
        this.archetypeService = archetypeService;
    }

    @PostMapping("add")
    public void addArchetype(@RequestBody Archetype archetype){
        archetypeService.save(archetype);
    }

    @PostMapping("addlist")
    public void addArchetypeList(@RequestBody List<Archetype> archetypeList){
        archetypeService.saveAll(archetypeList);
    }

    @PostMapping("remove")
    public void removeArchetype(@RequestParam Long id){
        archetypeService.remove(id);
    }

    @PostMapping("available")
    public void available(){
        archetypeService.checkAvailability(1L);
    }
}
