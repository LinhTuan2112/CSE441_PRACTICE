package com.example.cse441_btth03;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JsonUtils {
    public static String loadJSONFromAsset(Context context, String fileName) {
        StringBuilder json = new StringBuilder();
        try {
            InputStream is = context.getAssets().open(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }
        return json.toString();
    }
}

