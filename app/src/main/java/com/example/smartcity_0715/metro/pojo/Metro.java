package com.example.smartcity_0715.metro.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Metro {

    /**
     * lineId : 31
     * lineName : 2号线
     * preStep : {"name":"朝阳门","lines":[{"lineId":21,"lineName":"6号线"},{"lineId":24,"lineName":"6号线"},{"lineId":31,"lineName":"2号线"},{"lineId":38,"lineName":"2号线"}]}
     * nextStep : {"name":"北京站","lines":[{"lineId":31,"lineName":"2号线"},{"lineId":38,"lineName":"2号线"}]}
     * currentName : 建国门
     * reachTime : 6
     */

    @SerializedName("lineId")
    private Integer lineId;
    @SerializedName("lineName")
    private String lineName;
    @SerializedName("preStep")
    private PreStepDTO preStep;
    @SerializedName("nextStep")
    private NextStepDTO nextStep;
    @SerializedName("currentName")
    private String currentName;
    @SerializedName("reachTime")
    private Integer reachTime;

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

    public PreStepDTO getPreStep() {
        return preStep;
    }

    public void setPreStep(PreStepDTO preStep) {
        this.preStep = preStep;
    }

    public NextStepDTO getNextStep() {
        return nextStep;
    }

    public void setNextStep(NextStepDTO nextStep) {
        this.nextStep = nextStep;
    }

    public String getCurrentName() {
        return currentName;
    }

    public void setCurrentName(String currentName) {
        this.currentName = currentName;
    }

    public Integer getReachTime() {
        return reachTime;
    }

    public void setReachTime(Integer reachTime) {
        this.reachTime = reachTime;
    }

    public static class PreStepDTO {
        /**
         * name : 朝阳门
         * lines : [{"lineId":21,"lineName":"6号线"},{"lineId":24,"lineName":"6号线"},{"lineId":31,"lineName":"2号线"},{"lineId":38,"lineName":"2号线"}]
         */

        @SerializedName("name")
        private String name;
        @SerializedName("lines")
        private List<LinesDTO> lines;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<LinesDTO> getLines() {
            return lines;
        }

        public void setLines(List<LinesDTO> lines) {
            this.lines = lines;
        }

        public static class LinesDTO {
            /**
             * lineId : 21
             * lineName : 6号线
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
    }

    public static class NextStepDTO {
        /**
         * name : 北京站
         * lines : [{"lineId":31,"lineName":"2号线"},{"lineId":38,"lineName":"2号线"}]
         */

        @SerializedName("name")
        private String name;
        @SerializedName("lines")
        private List<LinesDTO> lines;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<LinesDTO> getLines() {
            return lines;
        }

        public void setLines(List<LinesDTO> lines) {
            this.lines = lines;
        }

        public static class LinesDTO {
            /**
             * lineId : 31
             * lineName : 2号线
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
    }
}
