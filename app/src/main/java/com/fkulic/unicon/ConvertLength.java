package com.fkulic.unicon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import static com.fkulic.unicon.Length.UNIT_FEET;
import static com.fkulic.unicon.Length.UNIT_INCH;
import static com.fkulic.unicon.Length.UNIT_KM;
import static com.fkulic.unicon.Length.UNIT_M;
import static com.fkulic.unicon.Length.UNIT_MILES;
import static com.fkulic.unicon.Length.UNIT_MM;
import static com.fkulic.unicon.Length.UNIT_THOU;
import static com.fkulic.unicon.Length.UNIT_YARD;
import static com.fkulic.unicon.ResultActivity.INPUT_UNIT;
import static com.fkulic.unicon.ResultActivity.INPUT_VALUE;
import static com.fkulic.unicon.ResultActivity.OUTPUT_UNIT;
import static com.fkulic.unicon.ResultActivity.OUTPUT_VALUE;

public class ConvertLength extends AppCompatActivity implements View.OnClickListener {


    Spinner sLengthInput;
    Spinner sLengthOutput;
    EditText etLength;
    Button bConvertLength;

    private Length mLength;

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
        double outputLength;

        try {
            inputLength = Double.parseDouble(lengthValue);
            this.mLength = new Length(inputLength, inputUnit);
            outputLength = outputUnit.equals(inputUnit) ? inputLength : convertLength(outputUnit);

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


    private double convertLength(String outputUnit) {
        switch (outputUnit) {
            case UNIT_MM:
                return this.mLength.toMillimeters();
            case UNIT_M:
                return this.mLength.getValueInMeters();
            case UNIT_KM:
                return this.mLength.toKilometers();
            case UNIT_THOU:
                return this.mLength.toThou();
            case UNIT_INCH:
                return this.mLength.toInch();
            case UNIT_FEET:
                return this.mLength.toFeet();
            case UNIT_YARD:
                return this.mLength.toYard();
            case UNIT_MILES:
                return this.mLength.toMiles();
        }
        return 0;
    }
}
