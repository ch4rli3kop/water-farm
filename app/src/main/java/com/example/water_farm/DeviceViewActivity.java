package com.example.water_farm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class DeviceViewActivity extends AppCompatActivity {
    private int de_prog_value; // 온도 값
    private int hu_prog_value; // 습도 값
    private int fe_prog_value; // 비료 값
    private int wa_prog_value; // 수위 값


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_view2);
        updateProgressBar();


    // Button ID
        Button btn_de_incr = (Button) findViewById(R.id.de_button_incr);
        Button btn_de_decr = (Button) findViewById(R.id.de_button_decr);
        Button btn_hu_incr = (Button) findViewById(R.id.hu_button_incr);
        Button btn_hu_decr = (Button) findViewById(R.id.hu_button_decr);
        Button btn_fe_incr = (Button) findViewById(R.id.fe_button_incr);
        Button btn_fe_decr = (Button) findViewById(R.id.fe_button_decr);
        Button btn_wa_incr = (Button) findViewById(R.id.wa_button_incr);
        Button btn_wa_decr = (Button) findViewById(R.id.wa_button_decr);


    // 온도 증가 버튼
        btn_de_incr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (de_prog_value < 100){
                    de_prog_value += 10;
                    updateProgressBar();
                }
            }
        });

    // 온도 감소 버튼
        btn_de_decr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (de_prog_value > 0){
                    de_prog_value -= 10;
                    updateProgressBar();
                }
            }
        });

        // 습도 증가 버튼
        btn_hu_incr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hu_prog_value < 100){
                    hu_prog_value += 10;
                    updateProgressBar();
                }
            }
        });


        // 습도 감소 버튼
        btn_hu_decr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hu_prog_value > 0){
                    hu_prog_value -= 10;
                    updateProgressBar();
                }
            }
        });

        // 비료 증가 버튼
        btn_fe_incr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fe_prog_value < 100){
                    fe_prog_value += 10;
                    updateProgressBar();
                }
            }
        });

        // 비료 감소 버튼
        btn_fe_decr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fe_prog_value > 0){
                    fe_prog_value -= 10;
                    updateProgressBar();
                }
            }
        });

        // 수위 증가 버튼
        btn_wa_incr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (wa_prog_value < 100){
                    wa_prog_value += 10;
                    updateProgressBar();
                }
            }
        });

        // 수위 감소 버튼
        btn_wa_decr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (wa_prog_value > 0){
                    wa_prog_value -= 10;
                    updateProgressBar();
                }
            }
        });
    }

    private final void updateProgressBar(){

    // ProgressBar 업데이트
        ProgressBar de_prog_bar = (ProgressBar) findViewById(R.id.de_progress_bar);
        ProgressBar hu_prog_bar = (ProgressBar) findViewById(R.id.hu_progress_bar);
        ProgressBar fe_prog_bar = (ProgressBar) findViewById(R.id.fe_progress_bar);
        ProgressBar wa_prog_bar = (ProgressBar) findViewById(R.id.wa_progress_bar);

        de_prog_bar.setProgress(de_prog_value);
        hu_prog_bar.setProgress(hu_prog_value);
        fe_prog_bar.setProgress(fe_prog_value);
        wa_prog_bar.setProgress(wa_prog_value);

    // TextView 업데이트
        TextView de_text_view = (TextView) findViewById(R.id.de_text_view_progress);
        TextView hu_text_view = (TextView) findViewById(R.id.hu_text_view_progress);
        TextView fe_text_view = (TextView) findViewById(R.id.fe_text_view_progress);
        TextView wa_text_view = (TextView) findViewById(R.id.wa_text_view_progress);

        de_text_view.setText(String.valueOf(de_prog_value) + "%");
        hu_text_view.setText(String.valueOf(hu_prog_value) + "%");
        fe_text_view.setText(String.valueOf(fe_prog_value) + "%");
        wa_text_view.setText(String.valueOf(wa_prog_value) + "%");
    }
}