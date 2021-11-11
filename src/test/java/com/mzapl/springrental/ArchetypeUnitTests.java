package com.mzapl.springrental;

import com.mzapl.springrental.model.Archetype;
import com.mzapl.springrental.model.Unit;
import com.mzapl.springrental.service.ArchetypeService;
import com.mzapl.springrental.service.UnitService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class ArchetypeUnitTests {

    @Autowired
    ArchetypeService archetypeService;
    @Autowired
    UnitService unitService;

    Archetype archetype;
    Unit unit;
//
//    @BeforeClass
//    public static void init(){
//        archetype = new Archetype();
//        unit = new Unit(archetype);
//    }

    @BeforeEach
    public void init2(){
        archetype = new Archetype();
        unit = new Unit(archetype);
        unit = unitService.save(unit);
        archetype = archetypeService.save(archetype);

    }


    @Test
    public void unitHasArchetype(){
        Assertions.assertEquals(archetype, unit.getArchetype());
    }

    @Test
    public void archetypeHasUnit(){
//        init2();
//        archetype = archetypeService.save(archetype);
//        unit = unitService.save(unit);
        archetypeService.addUnit(unit);
        Assertions.assertTrue(archetype.getUnits().contains(unit));
    }

    @Test
    public void unitAvailable(){
        Assertions.assertTrue(unit.isAvailable());
    }

    @Test
    public void archetypeUnitsNotEmpty(){
//        unit = unitService.save(unit);
        Assertions.assertTrue(archetype.getUnits().size() > 0);
    }

    @Test
    public void findArchetypeByUnit(){
        System.err.println(unitService.find(archetype));
        Assertions.assertTrue(false);
    }

    @Test
    public void archetypeHasAvailableUnit(){
        archetype.setUnits(unitService.find(archetype));
        archetypeService.checkAvailability(archetype);
        Assertions.assertTrue(archetype.getAvailable() > 0);
    }

    @AfterEach
    public void removeUnit(){
        unitService.remove(unit.getId());
        Assertions.assertFalse(unitService.find(unit.getId()).isPresent());
    }

    @AfterEach
    public void removeArchetype(){
        archetypeService.remove(archetype.getId());
        Assertions.assertFalse(archetypeService.find(archetype.getId()).isPresent());
    }
}
