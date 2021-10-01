package com.example.water_farm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 4;
    public static final String DATABASE_NAME = "DeviceData.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DataBases.LocationDB.SQL_CREATE_TABLE);
        db.execSQL(DataBases.DeviceDB.SQL_CREATE_TABLE);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(DataBases.LocationDB.SQL_DELETE_TABLE);
        db.execSQL(DataBases.DeviceDB.SQL_DELETE_TABLE);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public void insertLocationRecord(location_data_type location){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DataBases.LocationDB.LOCATIONID, location.getLocationID());
        values.put(DataBases.LocationDB.LOCATIONNAME, location.getLocationName());
        values.put(DataBases.LocationDB.LOCATIONIP, location.getLocationIP());
        values.put(DataBases.LocationDB.LOCATIONDEVICENUM, location.getDevices_num());

        db.insert(DataBases.LocationDB.TABLENAME, null, values);
    }

    public void insertDeviceRecord(device_data_type device){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DataBases.DeviceDB.DEVICEID, device.getDeviceID());
        values.put(DataBases.DeviceDB.DEVICENAME, device.getDeviceName());
        values.put(DataBases.DeviceDB.LOCATIONID, device.getLocationID());
        values.put(DataBases.DeviceDB.DEVICEPORT, device.getDevicePort());

        db.insert(DataBases.DeviceDB.TABLENAME, null, values);
    }

    public ArrayList<location_data_type> readLocationRecord(){
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                DataBases.LocationDB.LOCATIONID,
                DataBases.LocationDB.LOCATIONNAME,
                DataBases.LocationDB.LOCATIONIP,
                DataBases.LocationDB.LOCATIONDEVICENUM
        };
        String sortOrder = DataBases.LocationDB.LOCATIONID;
        Cursor cursor = db.query(DataBases.LocationDB.TABLENAME, projection, null, null, null, null, sortOrder);

        ArrayList<location_data_type> locations = new ArrayList<location_data_type>();
        while(cursor.moveToNext()){
            int LocationID = cursor.getInt(cursor.getColumnIndexOrThrow(DataBases.LocationDB.LOCATIONID));
            String LocationName = cursor.getString(cursor.getColumnIndexOrThrow(DataBases.LocationDB.LOCATIONNAME));
            String LocationIP = cursor.getString(cursor.getColumnIndexOrThrow(DataBases.LocationDB.LOCATIONIP));
            int LocationDeviceNum = cursor.getInt(cursor.getColumnIndexOrThrow(DataBases.LocationDB.LOCATIONDEVICENUM));

            location_data_type location = new location_data_type(LocationName, LocationIP, LocationID);
            locations.add(location);
        }
        return locations;
    }

    public ArrayList<device_data_type> readDeviceRecord(int LocationID){
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                DataBases.DeviceDB.DEVICEID,
                DataBases.DeviceDB.DEVICENAME,
                DataBases.DeviceDB.LOCATIONID,
                DataBases.DeviceDB.DEVICEPORT
        };
        String selection = DataBases.DeviceDB.LOCATIONID + " = ?";
        String[] selectionArgs = {String.valueOf(LocationID)};

        String sortOrder = DataBases.DeviceDB.DEVICEID;

        Cursor cursor = db.query(DataBases.DeviceDB.TABLENAME, projection, selection, selectionArgs, null, null, sortOrder);

        ArrayList<device_data_type> devices = new ArrayList<device_data_type>();
        while(cursor.moveToNext()){
            int DeviceID = cursor.getInt(cursor.getColumnIndexOrThrow(DataBases.DeviceDB.DEVICEID));
            int LocationID_ = cursor.getInt(cursor.getColumnIndexOrThrow(DataBases.DeviceDB.LOCATIONID));
            String DeviceName = cursor.getString(cursor.getColumnIndexOrThrow(DataBases.DeviceDB.DEVICENAME));
            int DevicePort = cursor.getInt(cursor.getColumnIndexOrThrow(DataBases.DeviceDB.DEVICEPORT));

            device_data_type device = new device_data_type(DeviceID, LocationID_, DeviceName, DevicePort);
            devices.add(device);
        }
        return devices;
    }

    // ToDo : update device num
}
