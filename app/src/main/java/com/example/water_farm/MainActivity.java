package com.example.water_farm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ArrayList<String> testdata = new ArrayList<String> ();
    ArrayList<location_data_type> location_list = new ArrayList<location_data_type>();
    ArrayAdapter adapter;

    int ADDLOCATION = 0;
    int ADDDEVICE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testdata.add("Location 1");
        testdata.add("Location 2");
        testdata.add("Location 3");
        testdata.add("Location 4");

        location_list.add(new location_data_type("House 1", "123.123.23.14"));
        location_list.add(new location_data_type("House 2", "123.123.23.234"));
        location_list.add(new location_data_type("House 3", "123.123.23.5555"));



        Button btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, AddLocationActivity.class);
                startActivityForResult(myIntent, ADDLOCATION);

            }
        });

        Button btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent myIntent2 = new Intent(MainActivity.this, AddDeviceActivity.class);
                startActivityForResult(myIntent2, ADDDEVICE);
            }
        });

        // 리스트에 대한 어댑터 추가
//        adapter = new ArrayAdapter<location_data_type>(this, android.R.layout.simple_list_item_2, location_list);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, testdata);

        ListView listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String strText = (String) adapterView.getItemAtPosition(i);
                Toast.makeText(getApplicationContext(), strText, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == ADDLOCATION){
            if (resultCode == RESULT_OK){
                location_data_type location = (location_data_type) data.getSerializableExtra("location");

                String locationName = location.getName();
                String locationIP = location.getIP();
//            Toast.makeText(getApplicationContext(), locationName, Toast.LENGTH_SHORT).show();
                testdata.add(locationName);
                location_list.add(location);
                adapter.notifyDataSetChanged();
            }
        }
        else if (requestCode == ADDDEVICE){
            if (resultCode == RESULT_OK){
                device_data_type device = (device_data_type) data.getSerializableExtra("device");

                adapter.notifyDataSetChanged();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}