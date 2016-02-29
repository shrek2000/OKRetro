package com.tikalk.okretro;

import android.content.Intent;
import android.os.SystemClock;
import android.test.ServiceTestCase;

import org.junit.Test;

import java.io.IOException;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

/**
 * Created by oren on 26/02/16.
 */
public class RestServiceTest extends ServiceTestCase<RestService> {
 
    public RestServiceTest() {
        super(RestService.class);
    }
    Intent intent;


    @Test
    public void testManufacturers(){
        intent = RestService.getManufacturererIntent(getContext());
        startService(intent);

        RestService service = getService();
        assertNotNull(service);
        service.onHandleIntent(intent);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testNewVechiles(){
        intent = RestService.getNewVechilesIntent(getContext());
        startService(intent);

        RestService service = getService();
        assertNotNull(service);
        service.onHandleIntent(intent);

        SystemClock.sleep(500000);
    }

    @Test
    public void testRecall(){
        intent = RestService.getRecallIntent(getContext(),"2015");
        startService(intent);

        RestService service = getService();
        assertNotNull(service);
        service.onHandleIntent(intent);

        SystemClock.sleep(500000);
    }
    @Test
    public void mockServer(){
        try {
            intent = RestService.getManufacturererIntent(getContext());
            MockWebServer server = new MockWebServer();

            // Schedule some responses.
            server.enqueue(new MockResponse().setBody("hello, world!"));
            server.enqueue(new MockResponse().setBody("sup, bra?"));
            server.enqueue(new MockResponse().setBody("yo dog"));
            // Start the server.
            server.start(80);
            startService(intent);
            RestService service = getService();
            assertNotNull(service);
            service.onHandleIntent(intent);
        } catch (IOException ex){
            fail(ex.getMessage());
        }

            SystemClock.sleep(500000);

    }

}
