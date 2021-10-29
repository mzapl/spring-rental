package com.mzapl.springrental.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Stock {
    ArrayList<Unit> availableUnits;
    ArrayList<Unit> rentedUnits;
    Map<Archetype, Integer> stockByArchetype = new HashMap<Archetype, Integer>();
}
