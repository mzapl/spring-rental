package com.mzapl.springrental.controller;

import com.mzapl.springrental.model.Archetype;
import com.mzapl.springrental.model.Unit;
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

    private final UnitService unitService;

    @Autowired
    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @GetMapping("all")
    public ResponseEntity<List<Unit>> getAll(){
        return ResponseEntity.ok(unitService.findAll());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Optional<Unit>> getById(@PathVariable String id){
        return ResponseEntity.ok(unitService.find(Long.valueOf(id)));
    }

    @GetMapping("by-archetype")
    public ResponseEntity<List<Unit>> getByArchetype(@RequestBody Archetype archetype){
        return ResponseEntity.ok(unitService.find(archetype));
    }

    @PostMapping("add")
    public void addUnit(@RequestBody Unit unit){
        unitService.save(unit);
    }

    @PostMapping("addlist")
    public void addUnitList(@RequestBody ArrayList<Unit> units){
        for (Unit u :
                units) {
            addUnit(u);
        }
    }

    @PostMapping("remove")
    public void removeUnit(@RequestParam Long id){
        unitService.remove(id);
    }
}
