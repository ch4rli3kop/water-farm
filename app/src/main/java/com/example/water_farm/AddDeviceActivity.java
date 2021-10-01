package com.example.water_farm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class AddDeviceActivity extends AppCompatActivity {
    int dlocationID = -1;
    int dport = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_device);

        EditText device_name = (EditText)findViewById(R.id.input_device_name);
        EditText device_location = (EditText)findViewById(R.id.editTextNumber);


        Intent myIntent = getIntent();
        ArrayList<location_data_type> location_list = (ArrayList<location_data_type>) myIntent.getSerializableExtra("location_list");

        ArrayList<String> location_list_str = new ArrayList<String>();
        for (location_data_type location : location_list){
            location_list_str.add(location.getLocationName());
        }

        ArrayList<String> port_list = new ArrayList<String>();
        for (int i=1000; i<2000; i++){
            port_list.add(String.valueOf(i));
        }

        // Port 번호 선택 Spinner
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner_port_select2);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, port_list);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                dport = Integer.parseInt(port_list.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        // 지역 선택 Spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner_location_select);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, location_list_str);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                dlocationID = ((location_data_type) location_list.get(i)).getLocationID();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        // 저장버튼
        Button btn1 = (Button) findViewById(R.id.save_device);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                String dname = device_name.getText().toString();
//                int dport = Integer.parseInt(device_port.getText().toString());
//                dlocationID = Integer.parseInt(device_location.getText().toString());

                if (dlocationID < 0){
                    Toast.makeText(getApplicationContext(), "지역을 선택해주세요!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (dport < 0){
                    Toast.makeText(getApplicationContext(), "포트를 선택해주세요!", Toast.LENGTH_SHORT).show();
                    return;
                }


                Intent myIntent = new Intent();
                device_data_type device = new device_data_type(0, dlocationID, dname, dport);

                myIntent.putExtra("device", (Serializable) device);

                setResult(RESULT_OK, myIntent);
                Toast.makeText(getApplicationContext(), "장치 추가 완료!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}