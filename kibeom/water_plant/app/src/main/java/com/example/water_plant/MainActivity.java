package com.example.water_plant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    String[] items={"sample1","sample2","sample3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
//    Spinner spinner = (Spinner) findViewById(R.id.spinner_machine);

//    ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//            this,andriod.R.layout.simple_
//    )
//    var items = getResources().getStringArray(R.array.machine_name)
}