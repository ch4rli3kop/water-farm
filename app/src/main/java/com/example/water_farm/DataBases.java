package com.example.water_farm;

import android.provider.BaseColumns;

public class DataBases {
    private DataBases() {}

    public static final class LocationDB implements BaseColumns {
        public static final String TABLENAME = "locationTable";
        public static final String LOCATIONID = "locationID";
        public static final String LOCATIONNAME = "locationName";
        public static final String LOCATIONIP = "locationIP";
        public static final String LOCATIONDEVICENUM = "locationDeviceNum";
        public static final String SQL_CREATE_TABLE =
                "create table if not exists " + TABLENAME + "(" +
                _ID + " integer primary key autoincrement," +
                LOCATIONID + " integer not null," +
                LOCATIONNAME + " text not null," +
                LOCATIONIP + " text not null," +
                LOCATIONDEVICENUM + " integer not null" +
                ")";
        public static final String SQL_DELETE_TABLE =
                "drop table if exists " + TABLENAME;
    }

    public static final class DeviceDB implements BaseColumns {
        public static final String TABLENAME = "deviceTable";
        public static final String DEVICEID = "deviceID";
        public static final String DEVICENAME = "deviceName";
        public static final String LOCATIONID = "locationID";
        public static final String DEVICEPORT = "devicePort";
        public static final String SQL_CREATE_TABLE =
                "create table if not exists " + TABLENAME + "(" +
                _ID + " integer primary key autoincrement," +
                DEVICEID + " integer not null," +
                DEVICENAME + " text not null," +
                LOCATIONID + " integer not null," +
                DEVICEPORT + " integer not null" +
                ")";
        public static final String SQL_DELETE_TABLE =
                "drop table if exists " + TABLENAME;
    }

    public static final class DataDB implements BaseColumns {
        public static final String TABLENAME = "dataDB";
        public static final String DEVICEID = "deviceID";
        public static final String LOCATIONID = "locationID";
        public static final String TEMPERATURE = "temperature";
        public static final String HUMIDITY = "humidity";
        public static final String FERTILIZER = "fertilizer";
        public static final String WATER = "water";
        public static final String SQL_CREATE_TABLE = "create table if not exists " + TABLENAME + "(" +
                _ID + " integer primary key autoincrement," +
                DEVICEID + " integer not null," +
                LOCATIONID + " integer not null," +
                TEMPERATURE + " integer not null," +
                HUMIDITY + " integer not null," +
                FERTILIZER + " integer not null," +
                WATER + " integer not null," +
                ")";
        public static final String SQL_DELETE_TABLE =
                "drop table if exists " + TABLENAME;
    }
}
