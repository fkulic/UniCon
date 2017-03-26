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
import static com.fkulic.unicon.Temperature.UNIT_C;
import static com.fkulic.unicon.Temperature.UNIT_DE;
import static com.fkulic.unicon.Temperature.UNIT_F;
import static com.fkulic.unicon.Temperature.UNIT_K;
import static com.fkulic.unicon.Temperature.UNIT_N;
import static com.fkulic.unicon.Temperature.UNIT_R;
import static com.fkulic.unicon.Temperature.UNIT_RE;
import static com.fkulic.unicon.Temperature.UNIT_RO;

public class ConvertTemp extends AppCompatActivity implements View.OnClickListener {


    Spinner sTempInput;
    Spinner sTempOutput;
    EditText etTemp;
    Button bConvertTemp;

    private Temperature mTemperature;

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
        double inputValue;
        double outputValue;

        try {
            inputValue = Double.parseDouble(tempValue);
            this.mTemperature = new Temperature(inputValue, inputUnit);
            outputValue = outputUnit.equals(inputUnit) ? inputValue : convertTemp(outputUnit);

            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
            intent.putExtra(INPUT_UNIT, inputUnit);
            intent.putExtra(OUTPUT_UNIT, outputUnit);
            intent.putExtra(INPUT_VALUE, inputValue);
            intent.putExtra(OUTPUT_VALUE, outputValue);
            this.startActivity(intent);

        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "Please enter number as value.", Toast.LENGTH_LONG).show();
        }

    }

    private double convertTemp(String outputUnit) {
        switch (outputUnit) {

            case UNIT_C:
                return this.mTemperature.getValueInCelsius();
            case UNIT_F:
                return this.mTemperature.toFahrenheit();
            case UNIT_K:
                return this.mTemperature.toKelvin();
            case UNIT_R:
                return this.mTemperature.toRankine();
            case UNIT_DE:
                return this.mTemperature.toDelisle();
            case UNIT_N:
                return this.mTemperature.toNewton();
            case UNIT_RE:
                return this.mTemperature.toReaumur();
            case UNIT_RO:
                return this.mTemperature.toRomer();
        }
        return 0;
    }

}