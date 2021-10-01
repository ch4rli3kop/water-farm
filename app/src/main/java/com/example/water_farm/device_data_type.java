package com.example.water_farm;

import java.io.Serializable;

public class device_data_type implements Serializable{
    private int deviceID;
    private int locationID;
    private String deviceName;
    private String locationName;
    private int port;

    public device_data_type(int deviceID, int locationID, String deviceName, int port){
        super();
        this.deviceID = deviceID;
        this.locationID = locationID;
        this.deviceName = deviceName;
//        this.locationName = locationName;
        this.port = port;
    }

    public int getDeviceID(){
        return this.deviceID;
    }

    public int getLocationID(){
        return this.locationID;
    }

    public String getDeviceName(){
        return this.deviceName;
    }

//    public String getLocationName(){
//        return this.locationName;
//    }

    public int getDevicePort(){
        return this.port;
    }

    public void setDeviceID(int deviceID){
        this.deviceID = deviceID;
    }
}
