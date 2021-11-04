package com.mzapl.springrental;

import com.mzapl.springrental.model.Archetype;
import com.mzapl.springrental.model.Unit;
import com.mzapl.springrental.service.ArchetypeService;
import com.mzapl.springrental.service.UnitService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
public class ArchetypeUnitTests {

    @Autowired
    ArchetypeService archetypeService;
    @Autowired
    UnitService unitService;

    static Archetype archetype;
    static Unit unit;

    @BeforeClass
    public static void init(){
        archetype = new Archetype();
        unit = new Unit(archetype);
    }

    @Test
    public void UnitHasArchetype(){
        Assertions.assertEquals(archetype, unit.getArchetype());
    }

    @Test
    public void ArchetypeHasUnit(){
        archetypeService.save(archetype);
        unitService.save(unit);
        archetypeService.addUnit(unit);
        Assertions.assertTrue(archetype.getUnits().contains(unit));
    }

    @Test
    public void archetypeHasAvailableUnit(){
        archetypeService.checkAvailability(archetype.getId());
        Assertions.assertTrue(archetype.getAvailable() > 0);
    }

}
