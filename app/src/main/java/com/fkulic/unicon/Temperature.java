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

    private String inputUnit;
    private double valueInCelsius;

    public Temperature(Double inputValue, String inputUnit) {
        this.inputUnit = inputUnit;
        toCelsius(inputValue);
    }

    public double getValueInCelsius() {
        return valueInCelsius;
    }

    private void toCelsius(Double inputValue) {
        switch (this.inputUnit) {
            case UNIT_C:
                this.valueInCelsius = inputValue;
                break;
            case UNIT_F:
                this.valueInCelsius = (inputValue - 32) * 5 / 9;
                break;
            case UNIT_K:
                this.valueInCelsius = inputValue - 273.15;
                break;
            case UNIT_R:
                this.valueInCelsius = (inputValue - 491.67) * 5 / 9;
                break;
            case UNIT_DE:
                this.valueInCelsius = 100 - inputValue * 2 / 3;
                break;
            case UNIT_N:
                this.valueInCelsius = inputValue * 100 / 33;
                break;
            case UNIT_RE:
                this.valueInCelsius = inputValue * 5 / 4;
                break;
            case UNIT_RO:
                this.valueInCelsius = (inputValue - 7.5) * 40 / 21;
                break;

        }
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
