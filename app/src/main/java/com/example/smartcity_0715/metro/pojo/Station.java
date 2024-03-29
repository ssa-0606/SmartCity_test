package com.example.smartcity_0715.metro.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Station {


    /**
     * id : 31
     * name : 2号线
     * first : 内环(积水潭)
     * end : 积水潭
     * startTime : 05:10
     * endTime : 22:20
     * cityId : 1
     * stationsNumber : 19
     * km : 70
     * runStationsName : 建国门
     * metroStepList : [{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"updateTime":"2021-04-05 15:47:12","remark":null,"params":{},"id":457,"name":"积水潭","seq":1,"lineId":31,"firstCh":"J"},{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"updateTime":"2021-04-05 15:47:12","remark":null,"params":{},"id":458,"name":"鼓楼大街","seq":2,"lineId":31,"firstCh":"G"},{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"updateTime":"2021-04-05 15:47:12","remark":null,"params":{},"id":459,"name":"安定门","seq":3,"lineId":31,"firstCh":"A"},{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"updateTime":"2021-04-05 15:47:12","remark":null,"params":{},"id":460,"name":"雍和宫","seq":4,"lineId":31,"firstCh":"Y"},{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"updateTime":"2021-04-05 15:47:12","remark":null,"params":{},"id":461,"name":"东直门","seq":5,"lineId":31,"firstCh":"D"},{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"updateTime":"2021-04-05 15:47:12","remark":null,"params":{},"id":462,"name":"东四十条","seq":6,"lineId":31,"firstCh":"D"},{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"updateTime":"2021-04-05 15:47:13","remark":null,"params":{},"id":463,"name":"朝阳门","seq":7,"lineId":31,"firstCh":"C"},{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"updateTime":"2021-04-05 15:47:13","remark":null,"params":{},"id":464,"name":"建国门","seq":8,"lineId":31,"firstCh":"J"},{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"updateTime":"2021-04-05 15:47:13","remark":null,"params":{},"id":465,"name":"北京站","seq":9,"lineId":31,"firstCh":"B"},{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"updateTime":"2021-04-05 15:47:13","remark":null,"params":{},"id":466,"name":"崇文门","seq":10,"lineId":31,"firstCh":"C"},{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"updateTime":"2021-04-05 15:47:13","remark":null,"params":{},"id":467,"name":"前门","seq":11,"lineId":31,"firstCh":"Q"},{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"updateTime":"2021-04-05 15:47:13","remark":null,"params":{},"id":468,"name":"和平门","seq":12,"lineId":31,"firstCh":"H"},{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"updateTime":"2021-04-05 15:47:13","remark":null,"params":{},"id":469,"name":"宣武门","seq":13,"lineId":31,"firstCh":"X"},{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"updateTime":"2021-04-05 15:47:13","remark":null,"params":{},"id":470,"name":"长椿街","seq":14,"lineId":31,"firstCh":"C"},{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"updateTime":"2021-04-05 15:47:13","remark":null,"params":{},"id":471,"name":"复兴门","seq":15,"lineId":31,"firstCh":"F"},{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"updateTime":"2021-04-05 15:47:13","remark":null,"params":{},"id":472,"name":"阜成门","seq":16,"lineId":31,"firstCh":"F"},{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"updateTime":"2021-04-05 15:47:13","remark":null,"params":{},"id":473,"name":"车公庄","seq":17,"lineId":31,"firstCh":"C"},{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"updateTime":"2021-04-05 15:47:13","remark":null,"params":{},"id":474,"name":"西直门","seq":18,"lineId":31,"firstCh":"X"},{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:40","updateBy":null,"updateTime":"2021-04-05 15:47:13","remark":null,"params":{},"id":475,"name":"积水潭","seq":19,"lineId":31,"firstCh":"J"}]
     * remainingTime : 14
     */

    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("first")
    private String first;
    @SerializedName("end")
    private String end;
    @SerializedName("startTime")
    private String startTime;
    @SerializedName("endTime")
    private String endTime;
    @SerializedName("cityId")
    private Integer cityId;
    @SerializedName("stationsNumber")
    private Integer stationsNumber;
    @SerializedName("km")
    private Integer km;
    @SerializedName("runStationsName")
    private String runStationsName;
    @SerializedName("remainingTime")
    private Integer remainingTime;
    @SerializedName("metroStepList")
    private List<MetroStepListDTO> metroStepList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getStationsNumber() {
        return stationsNumber;
    }

    public void setStationsNumber(Integer stationsNumber) {
        this.stationsNumber = stationsNumber;
    }

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }

    public String getRunStationsName() {
        return runStationsName;
    }

    public void setRunStationsName(String runStationsName) {
        this.runStationsName = runStationsName;
    }

    public Integer getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(Integer remainingTime) {
        this.remainingTime = remainingTime;
    }

    public List<MetroStepListDTO> getMetroStepList() {
        return metroStepList;
    }

    public void setMetroStepList(List<MetroStepListDTO> metroStepList) {
        this.metroStepList = metroStepList;
    }

    public static class MetroStepListDTO {
        /**
         * searchValue : null
         * createBy : null
         * createTime : 2018-07-23 02:28:40
         * updateBy : null
         * updateTime : 2021-04-05 15:47:12
         * remark : null
         * params : {}
         * id : 457
         * name : 积水潭
         * seq : 1
         * lineId : 31
         * firstCh : J
         */

        @SerializedName("searchValue")
        private Object searchValue;
        @SerializedName("createBy")
        private Object createBy;
        @SerializedName("createTime")
        private String createTime;
        @SerializedName("updateBy")
        private Object updateBy;
        @SerializedName("updateTime")
        private String updateTime;
        @SerializedName("remark")
        private Object remark;
        @SerializedName("params")
        private ParamsDTO params;
        @SerializedName("id")
        private Integer id;
        @SerializedName("name")
        private String name;
        @SerializedName("seq")
        private Integer seq;
        @SerializedName("lineId")
        private Integer lineId;
        @SerializedName("firstCh")
        private String firstCh;

        public Object getSearchValue() {
            return searchValue;
        }

        public void setSearchValue(Object searchValue) {
            this.searchValue = searchValue;
        }

        public Object getCreateBy() {
            return createBy;
        }

        public void setCreateBy(Object createBy) {
            this.createBy = createBy;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(Object updateBy) {
            this.updateBy = updateBy;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public ParamsDTO getParams() {
            return params;
        }

        public void setParams(ParamsDTO params) {
            this.params = params;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getSeq() {
            return seq;
        }

        public void setSeq(Integer seq) {
            this.seq = seq;
        }

        public Integer getLineId() {
            return lineId;
        }

        public void setLineId(Integer lineId) {
            this.lineId = lineId;
        }

        public String getFirstCh() {
            return firstCh;
        }

        public void setFirstCh(String firstCh) {
            this.firstCh = firstCh;
        }

        public static class ParamsDTO {
        }
    }
}
