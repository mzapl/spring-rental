package com.mzapl.springrental.controller;

import com.mzapl.springrental.model.Archetype;
import com.mzapl.springrental.service.ArchetypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/archetype/")
public class ArchetypeController {
    @Autowired
    ArchetypeService archetypeService;

    public ArchetypeController(ArchetypeService archetypeService) {
        this.archetypeService = archetypeService;
    }

    @PostMapping("add")
    void addArchetype(@RequestBody Archetype archetype){
        archetypeService.save(archetype);
    }

    @PostMapping("remove")
    void removeArchetype(@RequestParam Long id){
        archetypeService.remove(id);
    }
}
