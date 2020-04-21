package com.example.br;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.BatteryManager;
import android.widget.Toast;

public class BroadcastRecever extends BroadcastReceiver {
    int scale = -1;
    int level = -1;
    int voltage = -1;
    int temp = -1;
    @Override
    public void onReceive(Context context, Intent intent) {

if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction()))
{
boolean noconnectivity=intent.getBooleanExtra(
        ConnectivityManager.EXTRA_NO_CONNECTIVITY,false
);
if(noconnectivity)
{
    Toast.makeText(context,"no connection",Toast.LENGTH_LONG).show();
}
else {
    Toast.makeText(context,"Connection available",Toast.LENGTH_LONG).show();
}
}
//if(Intent.ACTION_BATTERY_LOW.equals(intent.getAction()))
//{
//    level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
//    scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
//    temp = intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, -1);
//    voltage = intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, -1);
////    boolean nobattrry=intent.getBooleanExtra(Intent.ACTION_BATTERY_LOW,false);
////    if(nobattrry)
////    {
////        Toast.makeText(context,"no battery",Toast.LENGTH_LONG).show();
////
////    }
////    else {
////        Toast.makeText(context,"Battery",Toast.LENGTH_LONG).show();
////    }
//
//
//}
    }
}
