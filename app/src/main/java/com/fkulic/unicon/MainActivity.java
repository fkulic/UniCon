package com.fkulic.unicon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import static com.fkulic.unicon.ConvertActivity.CONVERT_LENGTH;
import static com.fkulic.unicon.ConvertActivity.CONVERT_MASS;
import static com.fkulic.unicon.ConvertActivity.CONVERT_TEMP;
import static com.fkulic.unicon.ConvertActivity.CONVERT_VOLUME;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String NEXT_ACTIVITY = "next_activity";

    ImageView ivConvertTemp;
    ImageView ivConvertLength;
    ImageView ivConvertWeight;
    ImageView ivConvertVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpUI();
    }

    private void setUpUI() {
        ivConvertTemp = (ImageView) findViewById(R.id.ivConvertTemp);
        ivConvertLength = (ImageView) findViewById(R.id.ivConvertLength);
        ivConvertWeight = (ImageView) findViewById(R.id.ivConvertMass);
        ivConvertVolume = (ImageView) findViewById(R.id.ivConvertVolume);

        ivConvertTemp.setOnClickListener(this);
        ivConvertLength.setOnClickListener(this);
        ivConvertWeight.setOnClickListener(this);
        ivConvertVolume.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), ConvertActivity.class);
        switch (v.getId()) {
            case R.id.ivConvertTemp:
                intent.putExtra(NEXT_ACTIVITY, CONVERT_TEMP);
                break;
            case R.id.ivConvertLength:
                intent.putExtra(NEXT_ACTIVITY, CONVERT_LENGTH);
                break;
            case R.id.ivConvertMass:
                intent.putExtra(NEXT_ACTIVITY, CONVERT_MASS);
                break;
            case R.id.ivConvertVolume:
                intent.putExtra(NEXT_ACTIVITY, CONVERT_VOLUME);
                break;        }
        this.startActivity(intent);
    }
}
