package com.example.water_farm;

import java.io.Serializable;

public class location_data_type implements Serializable {
    private int locationID;
    private String location;
    private String IP;
    private int devices_num;

    public location_data_type(String location_name, String IP){
        super();
        this.location = location_name;
        this.IP = IP;
//        this.devices_num = devices_num;
    }

    public String getName(){
        return this.location;
    }

    public String getIP(){
        return this.IP;
    }

    public int getLocationID(){
        return this.locationID;
    }

    public int getDevices_num(){
        return this.devices_num;
    }
}
