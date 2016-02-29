package com.tikalk.okretro;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * //
 * //                startService(RestService.getRecallIntent(MainActivity.this ,"2015"));
 */
public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    private Spinner spinner;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences settings = getSharedPreferences(RestService.PREF_DATA, Context.MODE_PRIVATE);
        settings.registerOnSharedPreferenceChangeListener(MainActivity.this);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.queries);
        textView = (TextView) findViewById(R.id.responseText);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    startService(RestService.getManufacturererIntent(MainActivity.this));
                } else if (position == 1) {
                    startService(RestService.getNewVechilesIntent(MainActivity.this));
                } else if (position == 2) {
                    startService(RestService.getRecallIntent(MainActivity.this, "2015"));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                textView.setText("");
            }
        });

    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals("response")) {
            textView.setText(sharedPreferences.getString("response", ""));
        }

    }
}
