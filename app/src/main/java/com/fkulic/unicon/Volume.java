package com.fkulic.unicon;

import java.util.ArrayList;

/**
 * Created by Filip on 27.3.2017..
 */

class Volume extends Unit {
    public static final String UNIT_CMM = "cubic millimeter";
    public static final String UNIT_CC = "cubic centimeter";
    public static final String UNIT_CD = "cubic decimeter";
    public static final String UNIT_CM = "cubic meter";
    public static final String UNIT_FO = "fluid ounce";
    public static final String UNIT_GILL = "gill";
    public static final String UNIT_P = "pint";
    public static final String UNIT_Q = "quart";
    public static final String UNIT_G = "gallon";
    public static final String UNIT_ML = "milliliter";
    public static final String UNIT_CL = "centiliter";
    public static final String UNIT_DL = "deciliter";
    public static final String UNIT_L = "liter";

    private double volumeInLiters;

    public Volume() {
    }

    public Volume(double inputValue, String inputUnit) {
        this.volumeInLiters = toBasicUnit(inputValue, inputUnit);
    }

    @Override
    double toBasicUnit(double inputValue, String inputUnit) {
        switch (inputUnit) {
            case UNIT_CMM:
                return inputValue / 1000000;
            case UNIT_CC:
                return inputValue / 1000;
            case UNIT_CD:
                return inputValue;
            case UNIT_CM:
                return inputValue * 1000;
            case UNIT_FO:
                return inputValue * 0.0284130625;
            case UNIT_GILL:
                return inputValue * 0.1420653125;
            case UNIT_P:
                return inputValue * 0.56826125;
            case UNIT_Q:
                return inputValue * 1.1365225;
            case UNIT_G:
                return inputValue * 4.54609;
            case UNIT_ML:
                return inputValue / 1000;
            case UNIT_CL:
                return inputValue / 100;
            case UNIT_DL:
                return inputValue / 10;
            case UNIT_L:
                return inputValue;
        }
        return 0;
    }

    @Override
    public double getValueIn(String outputUnit) {
        switch (outputUnit) {
            case UNIT_CMM:
                return this.volumeInLiters * 1000000;
            case UNIT_CC:
                return this.volumeInLiters * 1000;
            case UNIT_CD:
                return this.volumeInLiters;
            case UNIT_CM:
                return this.volumeInLiters / 1000;
            case UNIT_FO:
                return this.volumeInLiters / 0.0284130625;
            case UNIT_GILL:
                return this.volumeInLiters / 0.1420653125;
            case UNIT_P:
                return this.volumeInLiters / 0.56826125;
            case UNIT_Q:
                return this.volumeInLiters / 1.1365225;
            case UNIT_G:
                return this.volumeInLiters / 4.54609;
            case UNIT_ML:
                return this.volumeInLiters * 1000;
            case UNIT_CL:
                return this.volumeInLiters * 100;
            case UNIT_DL:
                return this.volumeInLiters * 10;
            case UNIT_L:
                return this.volumeInLiters;
        }
        return 0;
    }

    @Override
    public ArrayList<String> getUnits() {
        ArrayList<String> units = new ArrayList<>();
        units.add(UNIT_CMM);
        units.add(UNIT_CC);
        units.add(UNIT_CD);
        units.add(UNIT_CM);
        units.add(UNIT_FO);
        units.add(UNIT_GILL);
        units.add(UNIT_P);
        units.add(UNIT_Q);
        units.add(UNIT_G);
        units.add(UNIT_ML);
        units.add(UNIT_CL);
        units.add(UNIT_DL);
        units.add(UNIT_L);
        return units;
    }
}



