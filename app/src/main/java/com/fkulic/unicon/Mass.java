package com.fkulic.unicon;

/**
 * Created by Filip on 27.3.2017..
 */

class Mass {
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

    public Mass(double inputValue, String inputUnit) {
        this.valueInKilograms = toKg(inputValue, inputUnit);
    }

    public double getValueInKilograms() {
        return valueInKilograms;
    }

    private double toKg(double inputValue, String inputUnit) {
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

    public double toMilligrams() {
        return this.valueInKilograms * 1000000;
    }

    public double toGrams() {
        return this.valueInKilograms * 1000;
    }

    public double toTonnes() {
        return this.valueInKilograms / 1000;
    }

    public double toGrains() {
        return this.valueInKilograms / 0.00006479891;
    }

    public double toOunces() {
        return this.valueInKilograms / 0.0283495231;
    }

    public double toPounds() {
        return this.valueInKilograms / 0.45359237;
    }

    public double toShortTons() {
        return this.valueInKilograms / 907.18474;
    }

    public double toLongTons() {
        return this.valueInKilograms / 1016.04691;
    }
}
