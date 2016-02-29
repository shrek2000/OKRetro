package com.tikalk.okretro.query.manufacturers;

import com.tikalk.okretro.beans.manafacturers.Manufacturers;
import com.tikalk.okretro.beans.recall.Recall;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by oren on 27/02/16.
 * root url : https://api.edmunds.com/api/
 */
public interface APIManufacturers {

    @GET("api/vehicle/v2/makes")
    public Call<Manufacturers> getAllVehicles(@Query("fmt") String format, @Query("api_key")String apiKey);

    @GET("api/vehicle/v2/makes")
    public Call<Manufacturers> getAllNewVehicles(@Query("fmt") String format, @Query("api_key")String apiKey, @Query("state")String state);

    @GET("v1/api/maintenance/recallrepository/findbymodelyearid?")
    public Call<Recall> getRecall( @Query("modelyearid")String year,@Query("fmt") String format, @Query("api_key")String apiKey);
}