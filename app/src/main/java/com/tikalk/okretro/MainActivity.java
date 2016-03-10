package com.tikalk.okretro;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.tikalk.okretro.client.ManafacturersClient;
import com.tikalk.okretro.query.APIKey;
import com.tikalk.okretro.query.manufacturers.APIManufacturers;
import com.tikalk.okretro.realm.recall.Recall;
import com.tikalk.okretro.realm.recall.RecallUtils;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * //
 * //                startService(RestService.getRecallIntent(MainActivity.this ,"2015"));
 */
public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    private Spinner spinner;
    private TextView textView;
    private Recall recall;
    private APIManufacturers apiManufacturers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apiManufacturers = new ManafacturersClient().getApiService();
        SharedPreferences settings = getSharedPreferences(RestService.PREF_DATA, Context.MODE_PRIVATE);
        settings.registerOnSharedPreferenceChangeListener(MainActivity.this);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.queries);
        textView = (TextView) findViewById(R.id.responseText);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    startService(RestService.getManufacturererIntent(MainActivity.this));
                } else if (position == 1) {
                    startService(RestService.getNewVechilesIntent(MainActivity.this));
                } else if (position == 2) {
//                    startService(RestService.getRecallIntent(MainActivity.this,"2015"));
//                    operationObservable.subscribe().
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

    private int loadRest(){
        Call<com.tikalk.okretro.beans.recall.Recall> allVehiclesCall = apiManufacturers.getRecall("2015", RestService.JSON_FORMAT, APIKey.KEY);
        allVehiclesCall.enqueue(new Callback<com.tikalk.okretro.beans.recall.Recall>() {
            @Override
            public void onResponse(Call<com.tikalk.okretro.beans.recall.Recall> call, Response<com.tikalk.okretro.beans.recall.Recall> response) {
                final Realm realm = Realm.getDefaultInstance();
                try {
                    realm.beginTransaction();
                    com.tikalk.okretro.realm.recall.Recall recallRealm = RecallUtils.convert(realm, response.body());
                    Log.i(RestService.class.toString(), "recall " + response.body());

                } catch (Throwable e) {
                    Log.e(RestService.class.getName(), e.getMessage(), e);
                } finally {
                    if (realm != null) {
                        realm.commitTransaction();
                    }
                }
            }

            @Override
            public void onFailure(Call<com.tikalk.okretro.beans.recall.Recall> call, Throwable t) {
                Log.e(RestService.class.toString(), "recall " + t.getMessage(), t);
            }
        });
        return 0;
    }

    final Observable operationObservable = Observable.create(new Observable.OnSubscribe<Subscriber>() {
        @Override
        public void call(Subscriber subscriber) {
            subscriber.onNext(loadRest());
            subscriber.onCompleted();

        }

    }).subscribeOn(Schedulers.io()) // subscribeOn the I/O thread
            .observeOn(AndroidSchedulers.mainThread()); // observeOn the UI Thread

}
