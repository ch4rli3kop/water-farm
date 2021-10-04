package com.example.water_farm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;

public class LocationViewActivity extends AppCompatActivity {
    ArrayAdapter adapter;
    ArrayList<String> device_name_list_str = new ArrayList<String>();
    location_data_type location;
    ArrayList<device_data_type> devices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_view);

//        int deviceID = ((GlobalData)getApplication()).getDeviceNum();

        Intent myIntent = getIntent();
        location = (location_data_type) myIntent.getSerializableExtra("location");

        // TextView Update
        String locationName = location.getLocationName();
        TextView textView = findViewById(R.id.setLocationName);
        textView.setText(locationName);

        // Generate device name list
        devices = location.getDevices();
        for (device_data_type device : devices){
            device_name_list_str.add(device.getDeviceName());
        }

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, device_name_list_str);

        ListView listview = (ListView) findViewById(R.id.listViewDeviceName);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String strText = (String) adapterView.getItemAtPosition(i);
                Toast.makeText(getApplicationContext(), "lID : "+devices.get(i).getLocationID()+", dID : "+devices.get(i).getDeviceID()+", Name : "+devices.get(i).getDeviceName(), Toast.LENGTH_SHORT).show();
                Log.d("tag", "lID : "+devices.get(i).getLocationID()+", dID : "+devices.get(i).getDeviceID()+", Name : "+devices.get(i).getDeviceName());

                Intent deviceIntent = new Intent(LocationViewActivity.this, DeviceViewActivity.class);
                device_data_type device = devices.get(i);
                deviceIntent.putExtra("device", (Serializable) device);
                startActivity(deviceIntent);
//                Intent myIntent = new Intent(MainActivity.this, DeviceViewActivity.class);
//
//                location_data_type location = location_list.get(i);
//                Log.d("tag", "value "+location.getName());
//
//                // Location data 및 device data 전달
//                myIntent.putExtra("location", (Serializable) location);
//                startActivity(myIntent);

            }
        });

    }
}