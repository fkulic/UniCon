package com.fkulic.unicon;

import java.util.ArrayList;

/**
 * Created by Filip on 26.3.2017..
 */

class Temperature extends Unit {
    public static final String UNIT_C = "°C";
    public static final String UNIT_F = "°F";
    public static final String UNIT_K = "K";
    public static final String UNIT_R = "°R";
    public static final String UNIT_DE = "°De";
    public static final String UNIT_N = "°N";
    public static final String UNIT_RE = "°Ré";
    public static final String UNIT_RO = "°Rø";

    private double valueInCelsius;

    public Temperature() {
    }

    public Temperature(double inputValue, String inputUnit) {
        this.valueInCelsius = toBasicUnit(inputValue, inputUnit);
    }

    @Override
    double toBasicUnit(double inputValue, String inputUnit) {
        switch (inputUnit) {
            case UNIT_C:
                return inputValue;
            case UNIT_F:
                return (inputValue - 32) * 5 / 9;
            case UNIT_K:
                return inputValue - 273.15;
            case UNIT_R:
                return (inputValue - 491.67) * 5 / 9;
            case UNIT_DE:
                return 100 - inputValue * 2 / 3;
            case UNIT_N:
                return inputValue * 100 / 33;
            case UNIT_RE:
                return inputValue * 5 / 4;
            case UNIT_RO:
                return (inputValue - 7.5) * 40 / 21;
        }
        return 0;
    }

    @Override
    public double getValueIn(String outputUnit) {
        switch (outputUnit) {
            case UNIT_C:
                return  this.valueInCelsius;
            case UNIT_F:
                return this.valueInCelsius * 9 / 5 + 32;
            case UNIT_K:
                return this.valueInCelsius + 273.15;
            case UNIT_R:
                return (this.valueInCelsius + 273.15) * 9 / 5;
            case UNIT_DE:
                return (100 - this.valueInCelsius) * 3 / 2;
            case UNIT_N:
                return this.valueInCelsius * 33 / 100;
            case UNIT_RE:
                return this.valueInCelsius * 4 / 5;
            case UNIT_RO:
                return this.valueInCelsius * 21 / 40 + 7.5;
        }
        return 0;
    }

    @Override
    public ArrayList<String> getUnits() {
        ArrayList<String> units = new ArrayList<>();
        units.add(UNIT_C);
        units.add(UNIT_F);
        units.add(UNIT_K);
        units.add(UNIT_R);
        units.add(UNIT_DE);
        units.add(UNIT_N);
        units.add(UNIT_RE);
        units.add(UNIT_RO);
        return units;
    }
}
