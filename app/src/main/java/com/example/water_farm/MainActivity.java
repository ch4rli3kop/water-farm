package com.example.water_farm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
//    ArrayList<String> testdata = new ArrayList<String> ();
    ArrayList<location_data_type> location_list = new ArrayList<location_data_type>();
    ArrayList<String> location_list_str = new ArrayList<String>();
    ArrayAdapter adapter;

    int ADDLOCATION = 0;
    int ADDDEVICE = 1;
    int device_num = 0;
    int location_num = 0;

    protected void init(){

        location_list.add(new location_data_type("House 1", "123.123.23.14", 0));
        location_list.add(new location_data_type("House 2", "123.123.23.234", 1));
        location_list.add(new location_data_type("House 3", "123.123.23.5555", 2));
        location_list.add(new location_data_type("House 4", "123.123.23.5555", 3));

        location_num = 4;


//
//        ((GlobalData) getApplication()).addLocation(new location_data_type("House 1", "123.123.23.14"));
//        ((GlobalData) getApplication()).addLocation(new location_data_type("House 2", "123.123.23.14"));
//        ((GlobalData) getApplication()).addLocation(new location_data_type("House 3", "123.123.23.14"));
//        ((GlobalData) getApplication()).addLocation(new location_data_type("House 4", "123.123.23.14"));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


        for(location_data_type location : location_list){
            location_list_str.add(location.getName());
        }


        Button btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 지역 추가
                Intent myIntent = new Intent(MainActivity.this, AddLocationActivity.class);
                startActivityForResult(myIntent, ADDLOCATION);

            }
        });

        Button btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 장치 추가
                Intent myIntent2 = new Intent(MainActivity.this, AddDeviceActivity.class);
                startActivityForResult(myIntent2, ADDDEVICE);
            }
        });

        // 리스트에 대한 어댑터 추가
//        adapter = new ArrayAdapter<location_data_type>(this, android.R.layout.simple_list_item_2, location_list);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, location_list_str);

        ListView listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String strText = (String) adapterView.getItemAtPosition(i);
                Intent myIntent = new Intent(MainActivity.this, LocationViewActivity.class);

                location_data_type location = location_list.get(i);
                Log.d("tag", "value "+location.getName());

                // Location data 및 device data 전달
                myIntent.putExtra("location", (Serializable) location);
                startActivity(myIntent);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == ADDLOCATION){
            if (resultCode == RESULT_OK){
                location_data_type location = (location_data_type) data.getSerializableExtra("location");
                location.setLocationID(location_num);
                location_num += 1;

                location_list.add(location);


                //                ((GlobalData) getApplication()).addLocation(location);
                String locationName = location.getName();
                String locationIP = location.getIP();


                //                ((GlobalData)getApplication()).addLocation(location);

//            Toast.makeText(getApplicationContext(), locationName, Toast.LENGTH_SHORT).show();
//                testdata.add(locationName);
                location_list_str.add(locationName);
                adapter.notifyDataSetChanged();
            }
        }
        else if (requestCode == ADDDEVICE){
            if (resultCode == RESULT_OK){
                device_data_type device = (device_data_type) data.getSerializableExtra("device");
                device.setDeviceID(device_num);
                device_num += 1;
                int locationID = device.getLocationID();


                location_list.get(locationID).addDevice(device);

//                location_data_type location = ((GlobalData)getApplication()).getLocation(locationID);
//                location.addDevice(device);

                adapter.notifyDataSetChanged();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}