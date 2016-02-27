package com.tikalk.okretro;

import android.content.Intent;
import android.test.ServiceTestCase;

/**
 * Created by oren on 26/02/16.
 */
public class RestServiceTest extends ServiceTestCase<RestService> {
 
    public RestServiceTest() {
        super(RestService.class);
    }

    public void testManufacturers(){
        Intent manufacturererIntent = RestService.getManufacturererIntent(getContext());
        startService(manufacturererIntent);
        RestService service = getService();
        assertNotNull(service);
        service.onHandleIntent(manufacturererIntent);
    }

}
