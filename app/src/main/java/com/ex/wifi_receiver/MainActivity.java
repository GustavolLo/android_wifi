package com.ex.wifi_receiver;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexions);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getWifiState();
        List<String> wifiNames = scanWifiConnexions();
        ListView listCons = findViewById(R.id.list_connexions);
        ArrayAdapter<String> adapterCons =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, wifiNames);
        listCons.setAdapter(adapterCons);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private List<String> scanWifiConnexions() {
        WifiManager wifiManager = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        // Get List of Available Wifi Networks
        List<ScanResult> availNetworks = wifiManager.getScanResults();
        List<String> wifiNames = new ArrayList<String>();

        if (availNetworks.size() > 0) {
            // Get Each network detail
            for (int i=0; i< availNetworks.size();i++) {
                ScanResult item = availNetworks.get(i);
                wifiNames.add(item.SSID);
            }
        } else {
            wifiNames.add("No connexions available.");
        }
        return wifiNames;
    }

    private void getWifiState() {
        WifiManager wifiManager = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        int state = wifiManager.getWifiState();
        String statusInfo = "Unknown";

        switch (state)  {
            case WifiManager.WIFI_STATE_DISABLING:
                statusInfo = "Disabling";
                break;
            case WifiManager.WIFI_STATE_DISABLED:
                statusInfo = "Disabled";
                break;
            case WifiManager.WIFI_STATE_ENABLING:
                statusInfo = "Enabling";
                break;
            case WifiManager.WIFI_STATE_ENABLED:
                statusInfo = "Enabled";
                break;
            case WifiManager.WIFI_STATE_UNKNOWN:
                statusInfo = "Unknown";
                break;
            default:
                statusInfo = "Unknown";
                break;
        }
        System.out.printf("WIFI STATE : %s\n", statusInfo);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}