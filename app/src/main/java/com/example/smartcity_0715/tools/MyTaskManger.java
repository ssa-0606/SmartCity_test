package com.example.smartcity_0715.tools;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
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

}
