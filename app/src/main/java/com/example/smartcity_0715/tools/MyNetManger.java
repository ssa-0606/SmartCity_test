package com.example.smartcity_0715.tools;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MyNetManger {

    public static String SERVER_IP = "http://218.7.112.123:10001";


    public static String GET(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static String GET_T(String url,String token) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).addHeader("Authorization",token).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static String POST_T(String url,String msg,String token) throws IOException {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody requestBody = RequestBody.create(msg,mediaType);
        Request request = new Request.Builder().url(url).method("POST",requestBody).addHeader("Content-Type","application/json").build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static String POST(String url,String msg) throws IOException {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody requestBody = RequestBody.create(msg,mediaType);
        Request request = new Request.Builder().url(url).method("POST",requestBody).addHeader("Content-Type","application/json").build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static String PUT_T(String url,String msg,String token) throws IOException {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody requestBody = RequestBody.create(msg,mediaType);
        Request request = new Request.Builder().url(url).method("POST",requestBody).addHeader("Content-Type","application/json").addHeader("Authorization",token).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }


}
