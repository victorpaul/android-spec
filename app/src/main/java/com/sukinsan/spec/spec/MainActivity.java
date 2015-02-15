package com.sukinsan.spec.spec;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private TextView txtIpAddress;
    private TextView drawablePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtIpAddress = (TextView)findViewById(R.id.txt_ip_address);
        drawablePath = (TextView)findViewById(R.id.txt_drawable_path);
    }

    @Override
    protected void onResume() {
        super.onResume();

        WifiManager wifiMgr = (WifiManager) getSystemService(WIFI_SERVICE);
        WifiInfo wifiInfo = wifiMgr.getConnectionInfo();
        int ip = wifiInfo.getIpAddress();
        txtIpAddress.setText("IP WIFI " + Formatter.formatIpAddress(ip));


        String metrix = getResources().getDisplayMetrics().toString();
        switch(getResources().getDisplayMetrics().densityDpi){
            case DisplayMetrics.DENSITY_LOW:
                metrix += " LDPI";
                break;
            case DisplayMetrics.DENSITY_MEDIUM:
                metrix += " MDPI";
                break;
            case DisplayMetrics.DENSITY_HIGH:
                metrix += " HDPI";
                break;
            case DisplayMetrics.DENSITY_XHIGH:
                metrix += " XHDPI";
                break;
            case DisplayMetrics.DENSITY_XXHIGH:
                metrix += " XXHDPI";
                break;
            case DisplayMetrics.DENSITY_XXXHIGH:
                metrix += " XXXHDPI";
                break;
        }
        drawablePath.setText(metrix);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
