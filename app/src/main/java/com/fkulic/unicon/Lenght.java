package com.fkulic.unicon;

/**
 * Created by Filip on 26.3.2017..
 */

class Lenght {
    public static final String UNIT_MM = "millimeter";
    public static final String UNIT_M = "meter";
    public static final String UNIT_KM = "kilometer";
    public static final String UNIT_THOU = "thou";
    public static final String UNIT_INCH = "inch";
    public static final String UNIT_FEET = "feet";
    public static final String UNIT_YARD = "yard";
    public static final String UNIT_MILES = "mile";

    private String inputUnit;
    private double valueInMeters;

    public Lenght(double inputValue, String inputUnit) {
        this.inputUnit = inputUnit;
        toMeters(inputValue);
    }

    public String getInputUnit() {
        return inputUnit;
    }

    public double getValueInMeters() {
        return valueInMeters;
    }

    private void toMeters(double inputValue) {
        switch (inputUnit) {
            case UNIT_MM:
                this.valueInMeters = inputValue / 1000;
                break;

            case UNIT_M:
                this.valueInMeters = inputValue;
                break;

            case UNIT_KM:
                this.valueInMeters = inputValue * 1000;
                break;

            case UNIT_THOU:
                this.valueInMeters = inputValue * 0.0000254;
                break;

            case UNIT_INCH:
                this.valueInMeters = inputValue * 0.0254;
                break;

            case UNIT_FEET:
                this.valueInMeters = inputValue * 0.3048;
                break;

            case UNIT_YARD:
                this.valueInMeters = inputValue * 0.9144;
                break;

            case UNIT_MILES:
                this.valueInMeters = inputValue * 1609.344;
                break;
        }
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

