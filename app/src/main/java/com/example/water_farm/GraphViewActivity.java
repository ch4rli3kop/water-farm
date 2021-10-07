package com.example.water_farm;

import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;


import android.os.Bundle;

import java.util.ArrayList;

public class GraphViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_view);

        LineChart line_chart_te = (LineChart) findViewById(R.id.te_line_chart);
        line_chart_te.setDragEnabled(true);
        line_chart_te.setScaleEnabled(false);

        ArrayList<Entry> yValues = new ArrayList<Entry>();
        yValues.add(new Entry(0,60f));
        yValues.add(new Entry(1,50f));
        yValues.add(new Entry(2,70f));
        yValues.add(new Entry(3,30f));
        yValues.add(new Entry(4,90f));

        LineDataSet set1 = new LineDataSet(yValues, "Data Set");
        set1.setFillAlpha(110);

        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(set1);
        LineData data = new LineData(dataSets);

        line_chart_te.setData(data);
    }
}