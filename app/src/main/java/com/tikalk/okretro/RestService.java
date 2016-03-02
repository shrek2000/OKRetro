package com.tikalk.okretro;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.util.Log;

import com.tikalk.okretro.beans.manafacturers.Manufacturers;
import com.tikalk.okretro.beans.recall.Recall;
import com.tikalk.okretro.client.ManafacturersClient;
import com.tikalk.okretro.query.APIKey;
import com.tikalk.okretro.query.manufacturers.APIManufacturers;
import com.tikalk.okretro.realm.recall.RecallUtils;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class RestService extends IntentService {
    public static String BASE_URL;
    public static final String PREF_DATA = "RESPONSE_PREF";
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_MANUFACTURERS = "com.tikalk.okretro.action.manu";
    private static final String ACTION_NEW_VEHICLES = "com.tikalk.okretro.action.new.man";
    private static final String ACTION_RECALL = "com.tikalk.okretro.action.recall";
    // TODO: Rename parameters
    private static final String API_KEY_PARAM = "com.tikalk.okretro.extra.api.key";
    private static final String FORMAT_PARM = "com.tikalk.okretro.extra.format";
    private static final String STATUS_PARM = "com.tikalk.okretro.extra.status";
    private static final String YEAR_PARAM = "com.tikalk.okretro.extra.year";
    private APIManufacturers apiManufacturers;
    public static final String PARAM_STATUS_VALUE = "new";
    public static final String JSON_FORMAT = "json";
    public RestService() {
        super("RestService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        BASE_URL = getString(R.string.base_url);
        apiManufacturers = new ManafacturersClient().getApiService();
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionManufacturers(Context context) {
        Intent intent = getManufacturererIntent(context);
        context.startService(intent);
    }

    @NonNull
    public static Intent getManufacturererIntent(Context context) {
        Intent intent = new Intent(context, RestService.class);
        intent.setAction(ACTION_MANUFACTURERS);
        intent.putExtra(API_KEY_PARAM, APIKey.KEY);
        intent.putExtra(FORMAT_PARM, JSON_FORMAT);
        return intent;
    }
    @NonNull
    public static Intent getNewVechilesIntent(Context context) {
        Intent intent = new Intent(context, RestService.class);
        intent.setAction(ACTION_NEW_VEHICLES);
        intent.putExtra(API_KEY_PARAM, APIKey.KEY);
        intent.putExtra(FORMAT_PARM, JSON_FORMAT);
        intent.putExtra(STATUS_PARM, PARAM_STATUS_VALUE);
        return intent;
    }

    @NonNull
    public static Intent getRecallIntent(Context context, String year) {
        Intent intent = new Intent(context, RestService.class);
        intent.setAction(ACTION_RECALL);
        intent.putExtra(API_KEY_PARAM, APIKey.KEY);
        intent.putExtra(FORMAT_PARM, JSON_FORMAT);
        intent.putExtra(YEAR_PARAM, year);
        return intent;
    }
    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionNewVehciles(Context context) {
        context.startService(getNewVechilesIntent(context));
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_MANUFACTURERS.equals(action)) {
                final String key = intent.getStringExtra(API_KEY_PARAM);
                final String format = intent.getStringExtra(FORMAT_PARM);
                handleActionManufacturers(key, format);
            } else if (ACTION_NEW_VEHICLES.equals(action)) {
                final String key = intent.getStringExtra(API_KEY_PARAM);
                final String format = intent.getStringExtra(FORMAT_PARM);
                final String status = intent.getStringExtra(STATUS_PARM);
                handleActionNewVehciles(key, format,status);
            }else if (ACTION_RECALL.equals(action)) {
                final String key = intent.getStringExtra(API_KEY_PARAM);
                final String format = intent.getStringExtra(FORMAT_PARM);
                final String year = intent.getStringExtra(YEAR_PARAM);
                handleActionRecall(key, format,year);
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionManufacturers(String key, String format) {
        Call< Manufacturers> allVehiclesCall = apiManufacturers.getAllVehicles(format, key);
        allVehiclesCall.enqueue(new Callback<Manufacturers>() {
                @Override
                public void onResponse(Call<Manufacturers> call, Response<Manufacturers> response) {
                    SharedPreferences settings = getSharedPreferences(PREF_DATA, Context.MODE_PRIVATE);
                    Manufacturers manufacturers = response.body();
                    settings.edit().putString("response",manufacturers.toString()).commit();
                    Log.i(RestService.class.toString(),"Manufacturers "+ response.message());

                }

                @Override
                public void onFailure(Call<Manufacturers> call, Throwable t) {
                    Log.e(RestService.class.toString(),"Manufacturers "+t.getMessage(),t);
                 }
            });
     }

    private void handleActionNewVehciles(String key, String format, String status) {
        Call< Manufacturers> allVehiclesCall = apiManufacturers.getAllNewVehicles(format, key,status);
        allVehiclesCall.enqueue(new Callback<Manufacturers>() {
            @Override
            public void onResponse(Call<Manufacturers> call, Response<Manufacturers> response) {
                SharedPreferences settings = getSharedPreferences(PREF_DATA, Context.MODE_PRIVATE);
                Manufacturers manufacturers = response.body();
                settings.edit().putString("response",manufacturers.toString()).commit();
                Log.i(RestService.class.toString(),"new cars "+ response.message());

            }

            @Override
            public void onFailure(Call<Manufacturers> call, Throwable t) {
                Log.e(RestService.class.toString(),"new cars "+t.getMessage(),t);
            }
        });
    }

    private void handleActionRecall(String key, String format, String year) {
        Call<Recall> allVehiclesCall = apiManufacturers.getRecall(year,format, key);
        allVehiclesCall.enqueue(new Callback<Recall>() {
            @Override
            public void onResponse(Call<Recall> call, Response<Recall> response) {
                try {
                    Realm realm = Realm.getInstance(RestService.this);
                    realm.beginTransaction();
                    com.tikalk.okretro.realm.recall.Recall recallRealm = RecallUtils.convert(realm,response.body());
                    realm.commitTransaction();
                    Log.i(RestService.class.toString(),"recall "+ response.message());
                } catch (Throwable e) {
                  Log.e(RestService.class.getName(),e.getMessage(),e);
                }

            }

            @Override
            public void onFailure(Call<Recall> call, Throwable t) {
                Log.e(RestService.class.toString(),"recall "+t.getMessage(),t);
            }
        });
    }
}
