package com.example.checkinternet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textStatus;
    ImageView imageNetwork;
    Button buttonStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textStatus= findViewById(R.id.text_status);
        imageNetwork= findViewById(R.id.image_check);
        buttonStatus= findViewById(R.id.button_status);
        buttonStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkNetwork();
                
            }
        });
        
    }

    // check the network
    private void checkNetwork() {
        boolean wifiConnected;
        boolean mobileConnected;
        ConnectivityManager con = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo infoActive = con.getActiveNetworkInfo();
        if(infoActive!=null && infoActive.isConnected()){
            wifiConnected = infoActive.getType() == ConnectivityManager.TYPE_WIFI;
            mobileConnected= infoActive.getType() == ConnectivityManager.TYPE_MOBILE;
            // ketika yang connect wifi
            if(wifiConnected){
                imageNetwork.setImageResource(R.drawable.ic_wifi_black);
                textStatus.setText("wifi connect");
            }
            // ketika yang connect adalah mobile paket
            else if(mobileConnected){
                imageNetwork.setImageResource(R.drawable.ic_wifi_mobile);
                textStatus.setText("mobile connect");
            }
        }
        else{
            imageNetwork.setImageResource(R.drawable.ic_wifi_no);
            textStatus.setText("no connect");

        }

    }
}
