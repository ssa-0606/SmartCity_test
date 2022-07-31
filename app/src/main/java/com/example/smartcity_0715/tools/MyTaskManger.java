package com.example.smartcity_0715.tools;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MyTaskManger {

    public static <T>CompletableFuture<List<T>> getListData(String url,String memeber,Class<T> tClass){
        CompletableFuture<List<T>> completableFuture = CompletableFuture.supplyAsync(() -> {
            List<T> tList = new ArrayList<>();
            try {
                String result = MyNetManger.GET(url);
                JsonArray items = new JsonParser().parse(result).getAsJsonObject().getAsJsonArray(memeber);
                for (JsonElement item : items) {
                    T t = new Gson().fromJson(item, tClass);
                    tList.add(t);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return tList;
        }); 
        return completableFuture;
    }

    public static <T>CompletableFuture<List<T>> getListDataByToken(String url,String memeber,Class<T> tClass,String token){
        CompletableFuture<List<T>> completableFuture = CompletableFuture.supplyAsync(() -> {
            List<T> tList = new ArrayList<>();
            try {
                String result = MyNetManger.GET_T(url,token);
                JsonArray items = new JsonParser().parse(result).getAsJsonObject().getAsJsonArray(memeber);
                for (JsonElement item : items) {
                    T t = new Gson().fromJson(item, tClass);
                    tList.add(t);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return tList;
        });
        return completableFuture;
    }

    public static <T>CompletableFuture<T> getData(String url,String member,Class<T> tClass){
        CompletableFuture<T> completableFuture = CompletableFuture.supplyAsync(() -> {
            T t = null;
            try {
                String result = MyNetManger.GET(url);
                JsonObject asJsonObject = new JsonParser().parse(result).getAsJsonObject().getAsJsonObject(member);
                t = new Gson().fromJson(asJsonObject,tClass);
            } catch (IOException e) {
                e.printStackTrace();
                t = null;
            }
            return t;
        });
        return completableFuture;
    }


    public static <T>CompletableFuture<T> getDataByToken(String url,String member,Class<T> tClass,String token){
        CompletableFuture<T> completableFuture = CompletableFuture.supplyAsync(() -> {
            T t = null;
            try {
                String result = MyNetManger.GET_T(url,token);
                JsonObject asJsonObject = new JsonParser().parse(result).getAsJsonObject().getAsJsonObject(member);
                t = new Gson().fromJson(asJsonObject,tClass);
            } catch (IOException e) {
                e.printStackTrace();
                t = null;
            }
            return t;
        });
        return completableFuture;
    }

}
