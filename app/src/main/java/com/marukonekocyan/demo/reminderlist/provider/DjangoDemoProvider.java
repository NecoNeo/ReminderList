package com.marukonekocyan.demo.reminderlist.provider;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;


/**
 * Created by marukonekocyan on 2018/9/22.
 */

public class DjangoDemoProvider {
    private static final String TAG = "djangoDemoTest";
    public static final String BASE_SERVER_URL = "http://192.168.0.100:8000";

    public JSONArray firstTest() {
        JSONArray resultJson = null;
        ServerProvider serverProvider = new ServerProvider();
        try {
            String resultStr = serverProvider.getStringFromRequest(BASE_SERVER_URL);
            Log.i(TAG, resultStr);
            resultJson = new JSONArray(resultStr);
            return resultJson;
        } catch (IOException ioe) {
            Log.e(TAG, "Failed to fetch data", ioe);
        } catch (JSONException jsonErr) {
            Log.e(TAG, "jsonParseError", jsonErr);
        } finally {
            if (resultJson == null) resultJson = new JSONArray();
            return resultJson;
        }
    }
}
