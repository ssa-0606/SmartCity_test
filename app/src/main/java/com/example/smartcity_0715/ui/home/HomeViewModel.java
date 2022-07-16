package com.example.smartcity_0715.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.smartcity_0715.pojo.CityService;
import com.example.smartcity_0715.pojo.LunBo;
import com.example.smartcity_0715.pojo.Press;
import com.example.smartcity_0715.pojo.PressCate;
import com.example.smartcity_0715.tools.MyNetManger;
import com.example.smartcity_0715.tools.MyTaskManger;

import java.util.List;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<List<LunBo>> lunbos;
    private final MutableLiveData<List<CityService>> serviceList;
    private final MutableLiveData<List<Press>> hotList;
    private final MutableLiveData<List<PressCate>> cateList;
    private final MutableLiveData<List<Press>> pressList;

    public HomeViewModel() {
        lunbos = new MutableLiveData<>();
        serviceList = new MutableLiveData<>();
        hotList = new MutableLiveData<>();
        cateList = new MutableLiveData<>();
        pressList = new MutableLiveData<>();
        MyTaskManger.getListData(MyNetManger.SERVER_IP+"/prod-api/api/rotation/list?type=2","rows",LunBo.class).thenAccept(lunbos::postValue);
        MyTaskManger.getListData(MyNetManger.SERVER_IP+"/prod-api/api/service/list","rows",CityService.class).thenAccept(serviceList::postValue);
        MyTaskManger.getListData(MyNetManger.SERVER_IP+"/prod-api/press/press/list?hot=Y","rows",Press.class).thenAccept(hotList::postValue);
        MyTaskManger.getListData(MyNetManger.SERVER_IP+"/prod-api/press/category/list","data",PressCate.class).thenAccept(cateList::postValue);
        MyTaskManger.getListData(MyNetManger.SERVER_IP+"/prod-api/press/press/list?type=9","rows",Press.class).thenAccept(pressList::postValue);

    }

    public MutableLiveData<List<LunBo>> getLunbos() {
        return lunbos;
    }

    public MutableLiveData<List<CityService>> getServiceList() {
        return serviceList;
    }

    public MutableLiveData<List<Press>> getHotList() {
        return hotList;
    }

    public MutableLiveData<List<PressCate>> getCateList() {
        return cateList;
    }

    public MutableLiveData<List<Press>> getPressList() {
        return pressList;
    }

    public void setPressList(int id){
        MyTaskManger.getListData(MyNetManger.SERVER_IP+"/prod-api/press/press/list?type="+id,"rows",Press.class).thenAccept(pressList::postValue);
    }

}