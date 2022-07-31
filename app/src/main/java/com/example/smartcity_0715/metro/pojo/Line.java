package com.example.smartcity_0715.metro.pojo;

import com.google.gson.annotations.SerializedName;

public class Line {

    /**
     * lineId : 1
     * lineName : 16号线
     */

    @SerializedName("lineId")
    private Integer lineId;
    @SerializedName("lineName")
    private String lineName;

    public Integer getLineId() {
        return lineId;
    }

    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }
}
