package com.fkulic.unicon;

import java.util.ArrayList;

/**
 * Created by Filip on 29.3.2017..
 */

public abstract class Unit {
    abstract double toBasicUnit(double inputValue, String inputUnit);
    public abstract double getValueIn(String outputUnit);
    public abstract ArrayList<String> getUnits();
}
