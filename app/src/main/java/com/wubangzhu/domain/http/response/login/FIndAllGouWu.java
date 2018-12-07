package com.wubangzhu.domain.http.response.login;

import java.io.Serializable;
import java.util.List;

public class FIndAllGouWu extends BaseResponse{

    /**
     * gwshopmodels : [{"id":1,"name":"小熊玩具","state":1,"pirce":100,"xa":3,"xb":4,"youfei":5,"picture":"http://192.168.0.102:9090/image/1.png","picture1":"http://192.168.0.102:9090/image/x.png","picture2":"","picture3":""}]
     * gwshopmodel : null
     */

    private Object gwshopmodel;
    private List<GwshopmodelsBean> gwshopmodels;

    public Object getGwshopmodel() {
        return gwshopmodel;
    }

    public void setGwshopmodel(Object gwshopmodel) {
        this.gwshopmodel = gwshopmodel;
    }

    public List<GwshopmodelsBean> getGwshopmodels() {
        return gwshopmodels;
    }

    public void setGwshopmodels(List<GwshopmodelsBean> gwshopmodels) {
        this.gwshopmodels = gwshopmodels;
    }

    public static class GwshopmodelsBean implements Serializable{
        /**
         * id : 1
         * name : 小熊玩具
         * state : 1
         * pirce : 100.0
         * xa : 3
         * xb : 4
         * youfei : 5
         * picture : http://192.168.0.102:9090/image/1.png
         * picture1 : http://192.168.0.102:9090/image/x.png
         * picture2 :
         * picture3 :
         */

        private int id;
        private String name;
        private int state;
        private double pirce;
        private int xa;
        private int xb;
        private int youfei;
        private String picture;
        private String picture1;
        private String picture2;
        private String picture3;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public double getPirce() {
            return pirce;
        }

        public void setPirce(double pirce) {
            this.pirce = pirce;
        }

        public int getXa() {
            return xa;
        }

        public void setXa(int xa) {
            this.xa = xa;
        }

        public int getXb() {
            return xb;
        }

        public void setXb(int xb) {
            this.xb = xb;
        }

        public int getYoufei() {
            return youfei;
        }

        public void setYoufei(int youfei) {
            this.youfei = youfei;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public String getPicture1() {
            return picture1;
        }

        public void setPicture1(String picture1) {
            this.picture1 = picture1;
        }

        public String getPicture2() {
            return picture2;
        }

        public void setPicture2(String picture2) {
            this.picture2 = picture2;
        }

        public String getPicture3() {
            return picture3;
        }

        public void setPicture3(String picture3) {
            this.picture3 = picture3;
        }
    }
}
