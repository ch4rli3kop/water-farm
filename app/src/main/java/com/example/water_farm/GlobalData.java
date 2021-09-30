package com.example.water_farm;

import android.app.Application;

import java.util.ArrayList;

public class GlobalData extends Application {
    private ArrayList<location_data_type> locations = new ArrayList<location_data_type>();
    private int entireDeviceNum;
    private int entireLocationNum;

    public GlobalData(){
        super();
        this.entireDeviceNum = 0;
        this.entireLocationNum = 0;
    }

    public location_data_type getLocation(int locationID) {
//        if (checkIndex(locationID))
//            return locations.get(locationID);
//        return
        return locations.get(locationID);
    }

    public boolean checkIndex(int idx){
        if (0 <= idx && idx < this.entireLocationNum) return true;
        else return false;
    }

    public void addLocation(location_data_type location){
        location.setLocationID(this.entireLocationNum);
        locations.add(location);
        this.entireLocationNum += 1;
    }

//    public ArrayList<>

    public int getEntireDeviceNum(){
        return this.entireDeviceNum;
    }

    public int getEntireLocationNum(){
        return this.entireLocationNum;
    }
}
