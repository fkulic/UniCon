package com.fkulic.unicon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    public static final String INPUT_UNIT = "input_unit";
    public static final String INPUT_VALUE = "input_value";
    public static final String OUTPUT_UNIT = "output_unit";
    public static final String OUTPUT_VALUE = "output_value";

    TextView tvResultInputUnit;
    TextView tvResultInputValue;
    TextView tvResultOutputUnit;
    TextView tvResultOutputValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setUpUI();
    }

    private void setUpUI() {
        tvResultInputUnit = (TextView) findViewById(R.id.tvResultInputUnit);
        tvResultInputValue = (TextView) findViewById(R.id.tvResultInputValue);
        tvResultOutputUnit = (TextView) findViewById(R.id.tvResultOutputUnit);
        tvResultOutputValue = (TextView) findViewById(R.id.tvResultOutputValue);

        Intent intent = getIntent();
        if (intent.hasExtra(INPUT_UNIT)) {
            tvResultInputUnit.setText(intent.getStringExtra(INPUT_UNIT));
        }
        if (intent.hasExtra(INPUT_VALUE)) {
            tvResultInputValue.setText(String.valueOf(intent.getDoubleExtra(INPUT_VALUE, 0)));
        }
        if (intent.hasExtra(OUTPUT_UNIT)) {
            tvResultOutputUnit.setText(intent.getStringExtra(OUTPUT_UNIT));
        }
        if (intent.hasExtra(OUTPUT_VALUE)) {
            tvResultOutputValue.setText(String.valueOf(intent.getDoubleExtra(OUTPUT_VALUE, 0)));
        }

    }
}
