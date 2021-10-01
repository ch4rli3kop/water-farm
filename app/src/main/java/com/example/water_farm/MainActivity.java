package com.example.water_farm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
//    ArrayList<String> testdata = new ArrayList<String> ();
//    ArrayList<location_data_type> location_list = new ArrayList<location_data_type>();
    ArrayList<location_data_type> location_list;
    ArrayList<String> location_list_str = new ArrayList<String>();
    ArrayAdapter adapter;
    DBHelper helper;
    SQLiteDatabase db;

    int ADDLOCATION = 0;
    int ADDDEVICE = 1;
    int device_num = 0;
    int location_num = 0;

    protected void makeDummy(){
        for (int i=0; i<4; i++){
            location_data_type location = new location_data_type("House "+i, "123.123.23.14", i);
            location_num += 1;
            helper.insertLocationRecord(location);
        }
//
//        location_list.add();
//        location_list.add(new location_data_type("House 2", "123.123.23.234", 1));
//        location_list.add(new location_data_type("House 3", "123.123.23.5555", 2));
//        location_list.add(new location_data_type("House 4", "123.123.23.5555", 3));

        device_data_type device = new device_data_type(0, 0, "Device 1", 10001);
        helper.insertDeviceRecord(device);
//        location_list.get(0).addDevice(new device_data_type(0, 0, "Device 1", 10001));

        device = new device_data_type(1, 0, "Device 2", 10001);
        helper.insertDeviceRecord(device);
        device = new device_data_type(2, 0, "Device 3", 10001);
        helper.insertDeviceRecord(device);
        device = new device_data_type(3, 0, "Device 4", 10001);
        helper.insertDeviceRecord(device);
        device = new device_data_type(4, 1, "Device 5", 10001);
        helper.insertDeviceRecord(device);
        device = new device_data_type(5, 1, "Device 6", 10001);
        helper.insertDeviceRecord(device);
        device = new device_data_type(6, 1, "Device 7", 10001);
        helper.insertDeviceRecord(device);
        device = new device_data_type(7, 2, "Device 8", 10001);
        helper.insertDeviceRecord(device);
        device = new device_data_type(8, 2, "Device 9", 10001);
        helper.insertDeviceRecord(device);
        device = new device_data_type(9, 3, "Device 10", 10001);
        helper.insertDeviceRecord(device);


//        location_num = 4;
        device_num = 10;

//
//        ((GlobalData) getApplication()).addLocation(new location_data_type("House 1", "123.123.23.14"));
//        ((GlobalData) getApplication()).addLocation(new location_data_type("House 2", "123.123.23.14"));
//        ((GlobalData) getApplication()).addLocation(new location_data_type("House 3", "123.123.23.14"));
//        ((GlobalData) getApplication()).addLocation(new location_data_type("House 4", "123.123.23.14"));

    }

    protected void init(){

        helper = new DBHelper(MainActivity.this);

        location_list = helper.readLocationRecord();
        Log.d("tag", "location list length : "+ location_list.size());

        if (location_list.size() < 1){
            makeDummy();
        }

        for (location_data_type location : location_list){
            ArrayList<device_data_type> devices = helper.readDeviceRecord(location.getLocationID());
            int length = devices.size();
            Log.d("tag", "length : "+length);
            device_num += length;
            location.setDevices(devices);
            location_num += 1;
        }



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


        for(location_data_type location : location_list){
            location_list_str.add(location.getLocationName());
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

                // spinner item 선택을 위한 전달
                myIntent2.putExtra("location_list", (Serializable) location_list);
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
                Log.d("tag", "value "+location.getLocationName());

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
                String locationName = location.getLocationName();
                String locationIP = location.getLocationIP();
                helper.insertLocationRecord(location);

                //                ((GlobalData)getApplication()).addLocation(location);

            //Toast.makeText(getApplicationContext(), locationName, Toast.LENGTH_SHORT).show();
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
                helper.insertDeviceRecord(device);
//                location_data_type location = ((GlobalData)getApplication()).getLocation(locationID);
//                location.addDevice(device);

                adapter.notifyDataSetChanged();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}