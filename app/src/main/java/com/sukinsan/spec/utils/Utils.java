package com.sukinsan.spec.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by victorpaul on 26/2/15.
 */
public class Utils {
    private static final String TAG = Utils.class.getSimpleName();

    public static boolean executeCmd(String command){
        StringBuffer output = new StringBuffer();
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = bufferedReader.readLine()) != null){
                Log.i(TAG,line);
            }

        }catch(IOException e){
            e.printStackTrace();
        }
        return true;
    }

    public static void toast(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }
}
