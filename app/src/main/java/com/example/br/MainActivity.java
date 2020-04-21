package com.example.br;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button b;
BroadcastRecever broadcastRecever=new BroadcastRecever();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"this",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter=new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(broadcastRecever,intentFilter);
//        IntentFilter intentFilter1=new IntentFilter(Intent.ACTION_BATTERY_LOW);
//        registerReceiver(broadcastRecever,intentFilter1);
        Intent BATTERYintent = this.registerReceiver(null, new IntentFilter(
                Intent.ACTION_BATTERY_CHANGED));
        assert BATTERYintent != null;
        int level = BATTERYintent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        if(level<20)
        {
        Toast.makeText(getApplicationContext(),"low battery"+level+"%",Toast.LENGTH_LONG).show();
    }}

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastRecever);
        unregisterReceiver(broadcastRecever);
    }
}
