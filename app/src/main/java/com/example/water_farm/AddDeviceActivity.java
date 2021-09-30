package com.example.water_farm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

public class AddDeviceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_device);

        Button btn1 = (Button) findViewById(R.id.save_device);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                EditText device_name = (EditText)findViewById(R.id.input_device_name);
                EditText device_port = (EditText)findViewById(R.id.input_device_port);


                String dname = device_name.getText().toString();
                String dport = device_port.getText().toString();

                Intent myIntent = new Intent();
                device_data_type device = new device_data_type(0, 0, dname, "locationName", dport);

                myIntent.putExtra("device", (Serializable) device);
                setResult(RESULT_OK, myIntent);
                Toast.makeText(getApplicationContext(), "장치 추가 완료!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}