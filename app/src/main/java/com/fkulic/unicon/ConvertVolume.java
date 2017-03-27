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
import static com.fkulic.unicon.Volume.UNIT_CC;
import static com.fkulic.unicon.Volume.UNIT_CD;
import static com.fkulic.unicon.Volume.UNIT_CL;
import static com.fkulic.unicon.Volume.UNIT_CM;
import static com.fkulic.unicon.Volume.UNIT_CMM;
import static com.fkulic.unicon.Volume.UNIT_DL;
import static com.fkulic.unicon.Volume.UNIT_FO;
import static com.fkulic.unicon.Volume.UNIT_GILL;
import static com.fkulic.unicon.Volume.UNIT_L;
import static com.fkulic.unicon.Volume.UNIT_ML;
import static com.fkulic.unicon.Volume.UNIT_P;
import static com.fkulic.unicon.Volume.UNIT_Q;
import static com.fkulic.unicon.Volume.UNIT_G;

public class ConvertVolume extends AppCompatActivity implements View.OnClickListener {

    Spinner sVolumeInput;
    Spinner sVolumeOutput;
    EditText etVolume;
    Button bConvertVolume;

    Volume mVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert_volume);
        setUpUI();
    }

    private void setUpUI() {
        sVolumeInput = (Spinner) findViewById(R.id.sVolumeInput);
        sVolumeOutput = (Spinner) findViewById(R.id.sVolumeOutput);
        etVolume = (EditText) findViewById(R.id.etVolumeValue);
        bConvertVolume = (Button) findViewById(R.id.bConvertVolume);

        bConvertVolume.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String inputUnit = sVolumeInput.getSelectedItem().toString();
        String outputUnit = sVolumeOutput.getSelectedItem().toString();
        String tempValue = etVolume.getText().toString();
        double inputValue;
        double outputValue;

        try {
            inputValue = Double.parseDouble(tempValue);
            this.mVolume = new Volume(inputValue, inputUnit);
            outputValue = outputUnit.equals(inputUnit) ? inputValue : convertVolume(outputUnit);

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

    private double convertVolume(String outputUnit) {
        switch (outputUnit) {
            case UNIT_CMM:
                return this.mVolume.toCubicMillimeters();
            case UNIT_CC:
                return this.mVolume.toCubicCentimeters();
            case UNIT_CD:
                return this.mVolume.toCubicDecimeters();
            case UNIT_CM:
                return this.mVolume.toCubicMeters();
            case UNIT_FO:
                return this.mVolume.toFluidOunces();
            case UNIT_GILL:
                return this.mVolume.toGills();
            case UNIT_P:
                return this.mVolume.toPints();
            case UNIT_Q:
                return this.mVolume.toQuarts();
            case UNIT_G:
                return this.mVolume.toGallons();
            case UNIT_ML:
                return this.mVolume.toMilliliters();
            case UNIT_CL:
                return this.mVolume.toCentiliters();
            case UNIT_DL:
                return this.mVolume.toDeciliters();
            case UNIT_L:
                return this.mVolume.getVolumeInLiters();
        }
        return 0;
    }
}
