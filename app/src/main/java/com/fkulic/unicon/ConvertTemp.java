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

public class ConvertTemp extends AppCompatActivity implements View.OnClickListener {

    public static final String UNIT_C = "°C";
    public static final String UNIT_F = "°F";
    public static final String UNIT_K = "K";

    Spinner sTempInput;
    Spinner sTempOutput;
    EditText etTemp;
    Button bConvertTemp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert_temp);
        setUpUI();
    }

    private void setUpUI() {
        sTempInput = (Spinner) findViewById(R.id.sTempInput);
        sTempOutput = (Spinner) findViewById(R.id.sTempOutput);
        etTemp = (EditText) findViewById(R.id.etTempValue);
        bConvertTemp = (Button) findViewById(R.id.bConvertTemp);

        bConvertTemp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String inputUnit = sTempInput.getSelectedItem().toString();
        String outputUnit = sTempOutput.getSelectedItem().toString();
        String tempValue = etTemp.getText().toString();
        double inputTemp;

        try {
            inputTemp = Double.parseDouble(tempValue);
            double outputTemp = convertTemp(inputUnit, outputUnit, inputTemp);
            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
            intent.putExtra(INPUT_UNIT, inputUnit);
            intent.putExtra(OUTPUT_UNIT, outputUnit);
            intent.putExtra(INPUT_VALUE, inputTemp);
            intent.putExtra(OUTPUT_VALUE,outputTemp);
            this.startActivity(intent);

        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "Please enter number as value.", Toast.LENGTH_LONG).show();
        }

    }

    private double convertTemp(String inputUnit, String outputUnit, double inputTemp) {
        double outputTemp = 0;
        switch (inputUnit) {
            case UNIT_C:
                if(outputUnit.equals(UNIT_C)) {
                    return inputTemp;
                } else if(outputUnit.equals(UNIT_F)) {
                    outputTemp = 1.8 * inputTemp + 32;
                } else {
                    outputTemp = inputTemp + 273.15;
                }
                break;

            case UNIT_F:
                if(outputUnit.equals(UNIT_F)) {
                    return inputTemp;
                } else if(outputUnit.equals(UNIT_C)) {
                    outputTemp = (inputTemp - 32) / 1.8;
                } else {
                    outputTemp = (inputTemp + 459.67) * (5/9);
                }
                break;
            case UNIT_K:
                if(outputUnit.equals(UNIT_K)) {
                    return inputTemp;
                } else if(outputUnit.equals(UNIT_C)) {
                    outputTemp = inputTemp - 273.15;
                } else {
                    outputTemp = inputTemp * (9/5) - 459.67;
                }
                break;

        }
        return outputTemp;
    }


}