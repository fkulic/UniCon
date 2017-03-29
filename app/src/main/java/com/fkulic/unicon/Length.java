package com.fkulic.unicon;

import java.util.ArrayList;

/**
 * Created by Filip on 26.3.2017..
 */

class Length extends Unit {
    public static final String UNIT_MM = "millimeter";
    public static final String UNIT_M = "meter";
    public static final String UNIT_KM = "kilometer";
    public static final String UNIT_THOU = "thou";
    public static final String UNIT_INCH = "inch";
    public static final String UNIT_FEET = "feet";
    public static final String UNIT_YARD = "yard";
    public static final String UNIT_MILES = "mile";

    private double valueInMeters;

    public Length() {
    }

    public Length(double inputValue, String inputUnit) {
        this.valueInMeters = toBasicUnit(inputValue, inputUnit);
    }

    @Override
    double toBasicUnit(double inputValue, String inputUnit) {
        switch (inputUnit) {
            case UNIT_MM:
                return inputValue / 1000;
            case UNIT_M:
                return inputValue;
            case UNIT_KM:
                return inputValue * 1000;
            case UNIT_THOU:
                return inputValue * 0.0000254;
            case UNIT_INCH:
                return inputValue * 0.0254;
            case UNIT_FEET:
                return inputValue * 0.3048;
            case UNIT_YARD:
                return inputValue * 0.9144;
            case UNIT_MILES:
                return inputValue * 1609.344;
        }
        return 0;
    }

    @Override
    public double getValueIn(String outputUnit) {
        switch (outputUnit) {
            case UNIT_MM:
                return this.valueInMeters * 1000;
            case UNIT_M:
                return this.valueInMeters;
            case UNIT_KM:
                return this.valueInMeters / 1000;
            case UNIT_THOU:
                return this.valueInMeters * 0.0000254;
            case UNIT_INCH:
                return this.valueInMeters * 0.0254;
            case UNIT_FEET:
                return this.valueInMeters / 0.3048;
            case UNIT_YARD:
                return this.valueInMeters / 0.9144;
            case UNIT_MILES:
                return this.valueInMeters / 1609.344;
        }
        return 0;
    }

    @Override
    public ArrayList<String> getUnits() {
        ArrayList<String> units = new ArrayList<>();
        units.add(UNIT_MM );
        units.add(UNIT_M );
        units.add(UNIT_KM );
        units.add(UNIT_THOU );
        units.add(UNIT_INCH );
        units.add(UNIT_FEET );
        units.add(UNIT_YARD );
        units.add(UNIT_MILES );
        return units;
    }
}

