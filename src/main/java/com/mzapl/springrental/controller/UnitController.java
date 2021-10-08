package com.mzapl.springrental.controller;

import com.mzapl.springrental.model.Archetype;
import com.mzapl.springrental.model.Unit;
import com.mzapl.springrental.service.ArchetypeService;
import com.mzapl.springrental.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/unit/")
public class UnitController {
    @Autowired
    UnitService unitService;

    @Autowired
    ArchetypeService archetypeService;

    public UnitController(UnitService unitService, ArchetypeService archetypeService) {
        this.unitService = unitService;
        this.archetypeService = archetypeService;
    }

    @GetMapping("all")
    ResponseEntity<List<Unit>> getAll(){
        return ResponseEntity.ok(unitService.findAll());
    }

    @GetMapping("{id}")
    ResponseEntity<Optional<Unit>> get(@PathVariable Long id){
        return ResponseEntity.ok(unitService.find(id));
    }

    @GetMapping("by-archetype")
    ResponseEntity<List<Unit>> getByArchetype(@RequestBody Archetype archetype){
        return ResponseEntity.ok(unitService.find(archetype));
    }

    @PostMapping("add")
    void addUnit(@RequestBody Unit unit){
        archetypeService.addUnit(unit);
        unitService.save(unit);
    }

    @PostMapping("addlist")
    void addUnitList(@RequestBody ArrayList<Unit> units){
        for (Unit u :
                units) {
            addUnit(u);
        }
    }

    @PostMapping("remove")
    void removeUnit(@RequestParam Long id){
        unitService.deleteById(id);
    }
}
