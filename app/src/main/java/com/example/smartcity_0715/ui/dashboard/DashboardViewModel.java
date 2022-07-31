package com.example.smartcity_0715.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.smartcity_0715.pojo.CityService;
import com.example.smartcity_0715.tools.MyNetManger;
import com.example.smartcity_0715.tools.MyTaskManger;

import java.util.List;

public class DashboardViewModel extends ViewModel {

    private final MutableLiveData<List<CityService>> cityService;

    public DashboardViewModel() {
        cityService = new MutableLiveData<>();
        MyTaskManger.getListData(MyNetManger.SERVER_IP+"/prod-api/api/service/list?serviceType=车主服务","rows",CityService.class).thenAccept(cityService::postValue);
    }

    public void setCityService(String type){
        MyTaskManger.getListData(MyNetManger.SERVER_IP+"/prod-api/api/service/list?serviceType="+type,"rows",CityService.class).thenAccept(cityService::postValue);
    }

    public LiveData<List<CityService>> getText() {
        return cityService;
    }
}