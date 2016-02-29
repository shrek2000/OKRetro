package com.tikalk.okretro;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * //                startService(RestService.getManufacturererIntent(MainActivity.this));
 //                startService(RestService.getNewVechilesIntent(MainActivity.this));
 //                startService(RestService.getRecallIntent(MainActivity.this ,"2015"));
 */
public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    private Button button;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences settings = getSharedPreferences(RestService.PREF_DATA, Context.MODE_PRIVATE);
        settings.registerOnSharedPreferenceChangeListener(MainActivity.this);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.manufactureres);
        textView = (TextView) findViewById(R.id.responseText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
              public void onClick(View v) {
                startService(RestService.getRecallIntent(MainActivity.this ,"2015"));
            }
        });
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if(key.equals("response")){
            textView.setText(sharedPreferences.getString("response",""));
        }

    }
}
