package com.mzapl.springrental.controller;

import com.mzapl.springrental.model.Archetype;
import com.mzapl.springrental.model.Unit;
import com.mzapl.springrental.service.ArchetypeService;
import com.mzapl.springrental.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
