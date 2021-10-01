package com.example.water_farm;

import android.app.Application;
import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;

public class location_data_type implements Serializable {
    private int locationID;
    private String locationName;
    private String IP;
    private int devices_num;
    private ArrayList<device_data_type> devices;

    public location_data_type(String location_name, String IP, int locationID){
        super();
        this.locationName = location_name;
        this.IP = IP;
        this.locationID = locationID;
        this.devices = new ArrayList<device_data_type>();
        this.devices_num = 0;
    }

    public String getLocationName(){
        return this.locationName;
    }

    public String getLocationIP(){
        return this.IP;
    }

    public void setDevices(ArrayList<device_data_type> devices){
        this.devices = devices;
    }

    public void addDevice(device_data_type device){
        devices.add(device);
        this.devices_num += 1;
        Log.d("tag", "Adding device is successful");
    }

    public int getLocationID(){
        return this.locationID;
    }

    public int getDevices_num(){
        return this.devices_num;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public ArrayList<device_data_type> getDevices(){
        return this.devices;
    }
}
