package com.tikalk.okretro;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tikalk.okretro.beans.manafacturers.Manufacturers;
import com.tikalk.okretro.client.ManafacturersClient;
import com.tikalk.okretro.query.APIKey;
import com.tikalk.okretro.query.manufacturers.APIManufacturers;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class RestService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_MANUFACTURERS = "com.tikalk.okretro.action.mana";
    private static final String ACTION_BAZ = "com.tikalk.okretro.action.BAZ";

    // TODO: Rename parameters
    private static final String API_KEY_PARAM = "com.tikalk.okretro.extra.api.key";
    private static final String FORMAT_PARM = "com.tikalk.okretro.extra.format";
    private APIManufacturers apiManufacturers;

    public static final String JSON_FORMAT = "json";
    public RestService() {
        super("RestService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
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

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, RestService.class);
        intent.setAction(ACTION_BAZ);
        intent.putExtra(API_KEY_PARAM, param1);
        intent.putExtra(FORMAT_PARM, param2);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_MANUFACTURERS.equals(action)) {
                final String key = intent.getStringExtra(API_KEY_PARAM);
                final String format = intent.getStringExtra(FORMAT_PARM);
                handleActionManufacturers(key, format);
            } else if (ACTION_BAZ.equals(action)) {
                final String param1 = intent.getStringExtra(API_KEY_PARAM);
                final String param2 = intent.getStringExtra(FORMAT_PARM);
                handleActionBaz(param1, param2);
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionManufacturers(String key, String format) {
            Manufacturers allVehicles = apiManufacturers.getAllVehicles(format, key);
             Gson gson = new GsonBuilder().create();
            Manufacturers r = gson.fromJson(allVehicles.toString(), Manufacturers.class);
            Log.i(RestService.class.toString(),"Manufacturers "+r);

    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
