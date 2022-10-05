package com.example.applicationtest;

import org.junit.Test;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ExampleUnitTest {
    @Test
    public void as() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://localhost:5000")
                .build();
        Response response = client.newCall(request).execute();
        String jsondata = response.body().string();
        System.out.printf(jsondata);
    }

}
