package com.marukonekocyan.demo.reminderlist.provider;

import android.util.Log;

import java.io.IOException;


/**
 * Created by marukonekocyan on 2018/9/22.
 */

public class DjangoDemoProvider {
    private static final String TAG = "djangoDemoTest";
    public static final String BASE_SERVER_URL = "http://192.168.0.100:8000";

    public void firstTest() {
        ServerProvider serverProvider = new ServerProvider();
        try {
            String result = serverProvider.getStringFromRequest(BASE_SERVER_URL);
            Log.i(TAG, result);
        } catch (IOException ioe) {
            Log.e(TAG, "Failed to fetch data", ioe);
        }
    }
}
