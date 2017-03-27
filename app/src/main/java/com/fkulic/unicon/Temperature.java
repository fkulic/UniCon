package com.fkulic.unicon;

/**
 * Created by Filip on 26.3.2017..
 */

class Temperature {
    public static final String UNIT_C = "°C";
    public static final String UNIT_F = "°F";
    public static final String UNIT_K = "K";
    public static final String UNIT_R = "°R";
    public static final String UNIT_DE = "°De";
    public static final String UNIT_N = "°N";
    public static final String UNIT_RE = "°Ré";
    public static final String UNIT_RO = "°Rø";

    private double valueInCelsius;

    public Temperature(Double inputValue, String inputUnit) {
        this.valueInCelsius = toCelsius(inputValue, inputUnit);
    }

    public double getValueInCelsius() {
        return valueInCelsius;
    }

    private double toCelsius(Double inputValue, String inputUnit) {
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

    public double toFahrenheit() {
        return this.valueInCelsius * 9 / 5 + 32;
    }

    public double toKelvin() {
        return this.valueInCelsius + 273.15;
    }

    public double toRankine() {
        return (this.valueInCelsius + 273.15) * 9 / 5;
    }

    public double toDelisle() {
        return (100 - this.valueInCelsius) * 3 / 2;
    }

    public double toNewton() {
        return this.valueInCelsius * 33 / 100;
    }

    public double toReaumur() {
        return this.valueInCelsius * 4 / 5;
    }

    public double toRomer() {
        return this.valueInCelsius * 21 / 40 + 7.5;
    }
}
