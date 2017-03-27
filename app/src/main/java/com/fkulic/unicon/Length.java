package com.fkulic.unicon;

/**
 * Created by Filip on 26.3.2017..
 */

class Length {
    public static final String UNIT_MM = "millimeter";
    public static final String UNIT_M = "meter";
    public static final String UNIT_KM = "kilometer";
    public static final String UNIT_THOU = "thou";
    public static final String UNIT_INCH = "inch";
    public static final String UNIT_FEET = "feet";
    public static final String UNIT_YARD = "yard";
    public static final String UNIT_MILES = "mile";

    private double valueInMeters;

    public Length(double inputValue, String inputUnit) {
        this.valueInMeters = toMeters(inputValue, inputUnit);
    }

    public double getValueInMeters() {
        return valueInMeters;
    }

    private double toMeters(double inputValue, String inputUnit) {
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

    public double toMillimeters() {
        return this.valueInMeters * 1000;
    }

    public double toKilometers() {
        return this.valueInMeters / 1000;
    }

    public double toThou() {
        return this.valueInMeters * 0.0000254;
    }

    public double toInch() {
        return this.valueInMeters * 0.0254;
    }

    public double toFeet() {
        return this.valueInMeters / 0.3048;
    }

    public double toYard() {
        return this.valueInMeters / 0.9144;
    }

    public double toMiles() {
        return this.valueInMeters / 1609.344;
    }
}

