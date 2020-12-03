//package com.ex.wifi_receiver;
//
//import android.net.wifi.WifiManager;
//import android.net.wifi.Broad
//
//public class Receiver {
//
//    public void initialize() {
//
//        WifiManager wifiManager = (WifiManager)
//                context.getSystemService(Context.WIFI_SERVICE);
//
//        BroadcastReceiver wifiScanReceiver = new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context c, Intent intent) {
//                boolean success = intent.getBooleanExtra(
//                        WifiManager.EXTRA_RESULTS_UPDATED, false);
//                if (success) {
//                    scanSuccess();
//                } else {
//                    // scan failure handling
//                    scanFailure();
//                }
//            }
//        };
//
//    };
//
//    public List<String> getScanWifiResults(List<String> results) {
//        return results;
//    }
//    WifiManager wifiManager = (WifiManager)
//            context.getSystemService(Context.WIFI_SERVICE);
//
//
//
//    IntentFilter intentFilter = new IntentFilter();
//intentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
//context.registerReceiver(wifiScanReceiver, intentFilter);
//
//    boolean success = wifiManager.startScan();
//if (!success) {
//        // scan failure handling
//        scanFailure();
//    }
//
////....
//
//    private void scanSuccess() {
//        List<ScanResult> results = wifiManager.getScanResults();
//  //... use new scan results ...
//    }
//
//    private void scanFailure() {
//        // handle failure: new scan did NOT succeed
//        // consider using old scan results: these are the OLD results!
//        List<ScanResult> results = wifiManager.getScanResults();
//  //... potentially use older scan results ...
//    }
//}
