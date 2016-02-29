package com.tikalk.okretro.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tikalk.okretro.ClientSupplier;
import com.tikalk.okretro.RestService;
import com.tikalk.okretro.query.manufacturers.APIManufacturers;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by oren on 27/02/16.
 */
public class ManafacturersClient {

    private APIManufacturers apiManufacturers;
      public ManafacturersClient()
    {

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RestService.BASE_URL).client( ClientSupplier.getOkHttpClient()).addConverterFactory(GsonConverterFactory.create())
                .build();

        apiManufacturers = retrofit.create(APIManufacturers.class);
    }

    public APIManufacturers getApiService()
    {
        return apiManufacturers;
    }
}
