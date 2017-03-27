package com.fkulic.unicon;

/**
 * Created by Filip on 27.3.2017..
 */

class Volume {
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

    public Volume(double inputValue, String inputUnit) {
        this.volumeInLiters = toLiters(inputValue, inputUnit);
    }

    public double getVolumeInLiters() {
        return volumeInLiters;
    }

    private double toLiters(double inputValue, String inputUnit) {
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

    public double toCubicMillimeters() {
        return this.volumeInLiters * 1000000;
    }

    public double toCubicCentimeters() {
        return this.volumeInLiters * 1000;
    }

    public double toCubicDecimeters() {
        return this.volumeInLiters;
    }

    public double toCubicMeters() {
        return this.volumeInLiters / 1000;
    }

    public double toFluidOunces() {
        return this.volumeInLiters / 0.0284130625;
    }

    public double toGills() {
        return this.volumeInLiters / 0.1420653125;
    }

    public double toPints() {
        return this.volumeInLiters / 0.56826125;
    }

    public double toQuarts() {
        return this.volumeInLiters / 1.1365225;
    }

    public double toGallons() {
        return this.volumeInLiters / 4.54609;
    }

    public double toMilliliters() {
        return this.volumeInLiters * 1000;
    }

    public double toCentiliters() {
        return this.volumeInLiters * 100;
    }

    public double toDeciliters() {
        return this.volumeInLiters * 10;
    }

}



