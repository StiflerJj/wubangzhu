package com.wubangzhu.domain.http.response.login;

import java.util.List;

public class FIndAllGouWu extends BaseResponse{

    private List<GwshopmodelsBean> gwshopmodels;

    public List<GwshopmodelsBean> getGwshopmodels() {
        return gwshopmodels;
    }

    public void setGwshopmodels(List<GwshopmodelsBean> gwshopmodels) {
        this.gwshopmodels = gwshopmodels;
    }

    public static class GwshopmodelsBean {
        /**
         * id : 1
         * name : 小熊玩具
         * state : 1
         * pirce : 100
         * xa : 3
         * xb : 4
         * youfei : 5
         * picur1 : null
         */

        private int id;
        private String name;
        private int state;
        private int pirce;
        private int xa;
        private int xb;
        private int youfei;
        private Object picur1;

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

        public int getPirce() {
            return pirce;
        }

        public void setPirce(int pirce) {
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

        public Object getPicur1() {
            return picur1;
        }

        public void setPicur1(Object picur1) {
            this.picur1 = picur1;
        }
    }
}
