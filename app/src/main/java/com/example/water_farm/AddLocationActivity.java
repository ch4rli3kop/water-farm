package com.example.water_farm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

public class AddLocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_location);


//        Intent myIntent = getIntent();
 //       String strText = myIntent.getStringExtra("test");
  //      Toast.makeText(getApplicationContext(), strText, Toast.LENGTH_SHORT).show();


        Button btn1 = (Button) findViewById(R.id.save_location);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                EditText location_name = (EditText)findViewById(R.id.input_location_name);
                EditText location_ip = (EditText)findViewById(R.id.input_location_ip);

                String name = location_name.getText().toString();
                String ip = location_ip.getText().toString();

                Intent myIntent = new Intent();
                location_data_type location = new location_data_type(name, ip);

                myIntent.putExtra("location", (Serializable) location);
                setResult(RESULT_OK, myIntent);
                Toast.makeText(getApplicationContext(), "지역 추가 완료!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}