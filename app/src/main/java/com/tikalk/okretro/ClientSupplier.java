package com.tikalk.okretro;

import okhttp3.OkHttpClient;

/**
 * Created by oren on 27/02/16.
 */
public class ClientSupplier {
    private static final OkHttpClient okHttpClient = new OkHttpClient();
    public static OkHttpClient getOkHttpClient(){
        return okHttpClient;
    }
}
