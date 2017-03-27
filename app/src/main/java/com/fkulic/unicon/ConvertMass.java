package com.fkulic.unicon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import static com.fkulic.unicon.Mass.UNIT_G;
import static com.fkulic.unicon.Mass.UNIT_GRAIN;
import static com.fkulic.unicon.Mass.UNIT_KG;
import static com.fkulic.unicon.Mass.UNIT_LTON;
import static com.fkulic.unicon.Mass.UNIT_MG;
import static com.fkulic.unicon.Mass.UNIT_OUNCE;
import static com.fkulic.unicon.Mass.UNIT_POUND;
import static com.fkulic.unicon.Mass.UNIT_STON;
import static com.fkulic.unicon.Mass.UNIT_T;
import static com.fkulic.unicon.ResultActivity.INPUT_UNIT;
import static com.fkulic.unicon.ResultActivity.INPUT_VALUE;
import static com.fkulic.unicon.ResultActivity.OUTPUT_UNIT;
import static com.fkulic.unicon.ResultActivity.OUTPUT_VALUE;

public class ConvertMass extends AppCompatActivity implements View.OnClickListener {

    Spinner sMassInput;
    Spinner sMassOutput;
    EditText etMass;
    Button bConvertMass;

    private Mass mMass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert_mass);
        setUpUI();
    }

    private void setUpUI() {
        sMassInput = (Spinner) findViewById(R.id.sMassInput);
        sMassOutput = (Spinner) findViewById(R.id.sMassOutput);
        etMass = (EditText) findViewById(R.id.etMassValue);
        bConvertMass = (Button) findViewById(R.id.bConvertMass);

        bConvertMass.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String inputUnit = sMassInput.getSelectedItem().toString();
        String outputUnit = sMassOutput.getSelectedItem().toString();
        String massValue = etMass.getText().toString();
        double inputValue;
        double outputValue;

        try {
            inputValue = Double.parseDouble(massValue);
            this.mMass = new Mass(inputValue, inputUnit);
            outputValue = outputUnit.equals(inputUnit) ? inputValue : convertMass(outputUnit);

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

    private double convertMass(String outputUnit) {
        switch (outputUnit) {
            case  UNIT_MG:
                return this.mMass.toMilligrams();
            case  UNIT_G:
                return this.mMass.toGrams();
            case  UNIT_KG:
                return this.mMass.getValueInKilograms();
            case  UNIT_T:
                return this.mMass.toTonnes();
            case  UNIT_GRAIN:
                return this.mMass.toGrains();
            case  UNIT_OUNCE:
                return this.mMass.toOunces();
            case  UNIT_POUND:
                return this.mMass.toPounds();
            case  UNIT_STON:
                return this.mMass.toShortTons();
            case  UNIT_LTON:
                return this.mMass.toLongTons();
        }
        return 0;
    }
}
