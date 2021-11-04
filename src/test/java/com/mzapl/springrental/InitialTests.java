package com.mzapl.springrental;

import com.mzapl.springrental.model.Archetype;
import com.mzapl.springrental.model.Customer;
import com.mzapl.springrental.model.Unit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InitialTests {

    @Test
    void simpleAssertion() {
        Assertions.assertEquals(1, 1);
    }

    @Test
    void customerHasName(){
        Customer customer = new Customer("Test", "Customer", "jk@gmail.com");
        Assertions.assertNotEquals(customer.getName(), null);
    }

    @Test
    void unitAvailableByDefault(){
        Unit unit = new Unit();
        Assertions.assertTrue(unit.isAvailable());
    }
}
