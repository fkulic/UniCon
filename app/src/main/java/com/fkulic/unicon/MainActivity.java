package com.fkulic.unicon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

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
        ivConvertWeight = (ImageView) findViewById(R.id.ivConvertWeight);
        ivConvertVolume = (ImageView) findViewById(R.id.ivConvertVolume);

        ivConvertTemp.setOnClickListener(this);
        ivConvertLength.setOnClickListener(this);
        ivConvertWeight.setOnClickListener(this);
        ivConvertVolume.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.ivConvertTemp:
                intent = new Intent(getApplicationContext(), ConvertTemp.class);
                break;

            case R.id.ivConvertLength:
                intent =  new Intent(getApplicationContext(), ConvertLength.class);
                break;

            case R.id.ivConvertWeight:
                intent = new Intent(getApplicationContext(), ConvertMass.class);
                break;

            case R.id.ivConvertVolume:

                break;
        }
        if (intent != null) {
            this.startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Something went horribly wrong!", Toast.LENGTH_LONG).show();
        }
    }
}
