package com.fkulic.unicon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import static com.fkulic.unicon.MainActivity.NEXT_ACTIVITY;
import static com.fkulic.unicon.ResultActivity.INPUT_UNIT;
import static com.fkulic.unicon.ResultActivity.INPUT_VALUE;
import static com.fkulic.unicon.ResultActivity.OUTPUT_UNIT;
import static com.fkulic.unicon.ResultActivity.OUTPUT_VALUE;

/**
 * Created by Filip on 29.3.2017..
 */

public class ConvertActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String CONVERT_TEMP = "convert_temp";
    public static final String CONVERT_LENGTH = "convert_length";
    public static final String CONVERT_MASS = "convert_mass";
    public static final String CONVERT_VOLUME = "convert_volume";

    Spinner sInputUnit;
    EditText etInputValue;
    Spinner sOutputUnit;
    Button bConvert;

    private String physicalProperty;
    ArrayList<String> spinnerArray;
    Unit mUnit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);

        Intent intent = getIntent();
        if (intent.hasExtra(NEXT_ACTIVITY)) {
            this.physicalProperty = intent.getStringExtra(NEXT_ACTIVITY);
        } else {
            Toast.makeText(getApplicationContext(), "Something went horribly wrong!", Toast.LENGTH_LONG).show();
        }
        setUpUI();
    }

    private void setUpUI() {
        sInputUnit = (Spinner) findViewById(R.id.sInputUnit);
        etInputValue = (EditText) findViewById(R.id.etInputValue);
        sOutputUnit = (Spinner) findViewById(R.id.sOutputUnit);
        bConvert = (Button) findViewById(R.id.bConvert);


        switch (physicalProperty) {
            case CONVERT_TEMP:
                mUnit = new Temperature();
                spinnerArray = mUnit.getUnits();
                break;
            case CONVERT_LENGTH:
                mUnit = new Length();
                spinnerArray = mUnit.getUnits();
                break;
            case CONVERT_MASS:
                mUnit = new Mass();
                spinnerArray = mUnit.getUnits();
                break;
            case CONVERT_VOLUME:
                mUnit = new Volume();
                spinnerArray = mUnit.getUnits();
                break;
        }
        ArrayAdapter<String> spinnerArayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spinnerArray);
        sInputUnit.setAdapter(spinnerArayAdapter);
        sOutputUnit.setAdapter(spinnerArayAdapter);

        bConvert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String inputUnit = sInputUnit.getSelectedItem().toString();
        String outputUnit = sOutputUnit.getSelectedItem().toString();
        String value = etInputValue.getText().toString();
        double inputValue;
        double outputValue;

        try {
            inputValue = Double.parseDouble(value);
            switch (physicalProperty) {
                case CONVERT_TEMP:
                    mUnit = new Temperature(inputValue, inputUnit);
                    break;
                case CONVERT_LENGTH:
                    mUnit = new Length(inputValue, inputUnit);
                    break;
                case CONVERT_MASS:
                    mUnit = new Mass(inputValue, inputUnit);
                    break;
                case CONVERT_VOLUME:
                    mUnit = new Volume(inputValue, inputUnit);
                    break;
            }
            outputValue = mUnit.getValueIn(outputUnit);

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
}
