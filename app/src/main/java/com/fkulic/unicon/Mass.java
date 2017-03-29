package com.fkulic.unicon;

import java.util.ArrayList;

/**
 * Created by Filip on 27.3.2017..
 */

class Mass extends Unit {
    public static final String UNIT_MG = "milligram";
    public static final String UNIT_G = "gram";
    public static final String UNIT_KG = "kilogram";
    public static final String UNIT_T = "tonne";
    public static final String UNIT_GRAIN = "grain";
    public static final String UNIT_OUNCE = "ounce";
    public static final String UNIT_POUND = "pound";
    public static final String UNIT_STON = "long ton";
    public static final String UNIT_LTON = "short ton";

    private double valueInKilograms;

    public Mass() {
    }

    public Mass(double inputValue, String inputUnit) {
        this.valueInKilograms = toBasicUnit(inputValue, inputUnit);
    }

    @Override
    double toBasicUnit(double inputValue, String inputUnit) {
        switch (inputUnit) {
            case UNIT_MG:
                return inputValue * 0.000001;
            case UNIT_G:
                return inputValue * 0.001;
            case UNIT_KG:
                return inputValue;
            case UNIT_T:
                return inputValue * 1000;
            case UNIT_GRAIN:
                return inputValue * 0.00006479891;
            case UNIT_OUNCE:
                return inputValue * 0.0283495231;
            case UNIT_POUND:
                return inputValue * 0.45359237;
            case UNIT_STON:
                return inputValue * 907.18474;
            case UNIT_LTON:
                return inputValue * 1016.04691;
        }
        return 0;
    }

    @Override
    public double getValueIn(String outputUnit) {
        switch (outputUnit) {
            case UNIT_MG:
                return this.valueInKilograms * 1000000;
            case UNIT_G:
                return this.valueInKilograms * 1000;
            case UNIT_KG:
                return this.valueInKilograms;
            case UNIT_T:
                return this.valueInKilograms / 1000;
            case UNIT_GRAIN:
                return this.valueInKilograms / 0.00006479891;
            case UNIT_OUNCE:
                return this.valueInKilograms / 0.0283495231;
            case UNIT_POUND:
                return this.valueInKilograms / 0.45359237;
            case UNIT_STON:
                return this.valueInKilograms / 907.18474;
            case UNIT_LTON:
                return this.valueInKilograms / 1016.04691;
        }
        return 0;
    }

    @Override
    public ArrayList<String> getUnits() {
        ArrayList<String> units = new ArrayList<>();
        units.add(UNIT_MG);
        units.add(UNIT_G);
        units.add(UNIT_KG);
        units.add(UNIT_T);
        units.add(UNIT_GRAIN);
        units.add(UNIT_OUNCE);
        units.add(UNIT_POUND);
        units.add(UNIT_STON);
        units.add(UNIT_LTON);
        return units;
    }
}
