package com.fkulic.unicon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import static com.fkulic.unicon.ResultActivity.INPUT_UNIT;
import static com.fkulic.unicon.ResultActivity.INPUT_VALUE;
import static com.fkulic.unicon.ResultActivity.OUTPUT_UNIT;
import static com.fkulic.unicon.ResultActivity.OUTPUT_VALUE;

public class ConvertLength extends AppCompatActivity implements View.OnClickListener {

    public static final String UNIT_MM = "millimeter";
    public static final String UNIT_M = "meter";
    public static final String UNIT_KM = "kilometer";
    public static final String UNIT_INCH = "inch";
    public static final String UNIT_FEET = "feet";
    public static final String UNIT_MILES = "mile";

    Spinner sLengthInput;
    Spinner sLengthOutput;
    EditText etLength;
    Button bConvertLength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert_length);
        setUpUI();
    }

    private void setUpUI() {
        sLengthInput = (Spinner) findViewById(R.id.sLengthInput);
        sLengthOutput = (Spinner) findViewById(R.id.sLengthOutput);
        etLength = (EditText) findViewById(R.id.etLengthValue);
        bConvertLength = (Button) findViewById(R.id.bConvertLength);

        bConvertLength.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String inputUnit = sLengthInput.getSelectedItem().toString();
        String outputUnit = sLengthOutput.getSelectedItem().toString();
        String lengthValue = etLength.getText().toString();
        double inputLength;

        try {
            inputLength = Double.parseDouble(lengthValue);
            double outputLength = convertLength(inputUnit, outputUnit, inputLength);
            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
            intent.putExtra(INPUT_UNIT, inputUnit);
            intent.putExtra(OUTPUT_UNIT, outputUnit);
            intent.putExtra(INPUT_VALUE, inputLength);
            intent.putExtra(OUTPUT_VALUE, outputLength);
            this.startActivity(intent);

        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "Please enter number as value.", Toast.LENGTH_LONG).show();
        }
    }

    private double convertLength(String inputUnit, String outputUnit, double inputLength) {
        double outputLength = 0;
        switch (inputUnit) {
            case UNIT_MM:
                switch (outputUnit) {
                    case UNIT_MM:
                        return inputLength;

                    case UNIT_M:
                        outputLength = inputLength / 1000;
                        break;

                    case UNIT_KM:
                        outputLength = inputLength / 1000000;
                        break;

                    case UNIT_INCH:
                        outputLength = inputLength * 0.03937;
                        break;

                    case UNIT_FEET:
                        outputLength = inputLength * 0.0032808399;
                        break;

                    case UNIT_MILES:
                        outputLength = inputLength * 0.00000062137;
                        break;
                }
                break;

            case UNIT_M:
                switch (outputUnit) {
                    case UNIT_MM:
                        outputLength = inputLength * 1000;
                        break;

                    case UNIT_M:
                        return inputLength;

                    case UNIT_KM:
                        outputLength = inputLength / 1000;
                        break;

                    case UNIT_INCH:
                        outputLength = inputLength * 39.37;
                        break;

                    case UNIT_FEET:
                        outputLength = inputLength * 3.2808399;
                        break;

                    case UNIT_MILES:
                        outputLength = inputLength * 0.00062137;
                        break;
                }
                break;

            case UNIT_KM:
                switch (outputUnit) {
                    case UNIT_MM:
                        outputLength = inputLength * 1000000;
                        break;

                    case UNIT_M:
                        outputLength = inputLength * 1000;
                        break;

                    case UNIT_KM:
                        return inputLength;

                    case UNIT_INCH:
                        outputLength = inputLength * 39370;
                        break;

                    case UNIT_FEET:
                        outputLength = inputLength * 3280.8399;
                        break;

                    case UNIT_MILES:
                        outputLength = inputLength * 0.62137;
                        break;
                }
                break;

            case UNIT_INCH:
                switch (outputUnit) {
                    case UNIT_MM:
                        outputLength = inputLength * 25.4;
                        break;

                    case UNIT_M:
                        outputLength = inputLength * 0.0254;
                        break;

                    case UNIT_KM:
                        outputLength = inputLength * 0.0000254;
                        break;

                    case UNIT_INCH:
                        return inputLength;

                    case UNIT_FEET:
                        outputLength = inputLength / 12;
                        break;

                    case UNIT_MILES:
                        outputLength = inputLength / 63360;
                        break;
                }
                break;

            case UNIT_FEET:
                switch (outputUnit) {
                    case UNIT_MM:
                        outputLength = inputLength * 304.8;
                        break;

                    case UNIT_M:
                        outputLength = inputLength * 0.3048;
                        break;

                    case UNIT_KM:
                        outputLength = inputLength * 0.0003048;
                        break;

                    case UNIT_INCH:
                        outputLength = inputLength * 12;
                        break;

                    case UNIT_FEET:
                        return inputLength;

                    case UNIT_MILES:
                        outputLength = inputLength / 5280;
                        break;
                }
                break;

            case UNIT_MILES:
                switch (outputUnit) {
                    case UNIT_MM:
                        outputLength = inputLength * 1609344;
                        break;

                    case UNIT_M:
                        outputLength = inputLength * 1609.344;
                        break;

                    case UNIT_KM:
                        outputLength = inputLength * 1.609344;
                        break;

                    case UNIT_INCH:
                        outputLength = inputLength * 63360;
                        break;

                    case UNIT_FEET:
                        outputLength = inputLength * 5280;
                        break;

                    case UNIT_MILES:
                        return inputLength;
                }
                break;
        }
        return outputLength;
    }
}
