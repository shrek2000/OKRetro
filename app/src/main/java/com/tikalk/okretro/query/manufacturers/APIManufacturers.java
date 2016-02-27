package com.tikalk.okretro.query.manufacturers;

import com.tikalk.okretro.beans.manafacturers.Manufacturers;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by oren on 27/02/16.
 * root url : https://api.edmunds.com/api/
 */
public interface APIManufacturers {

    @GET("vehicle/v2/makes")
    public Manufacturers getAllVehicles(@Query("fmt") String format, @Query("api_key")String apiKey);
}
