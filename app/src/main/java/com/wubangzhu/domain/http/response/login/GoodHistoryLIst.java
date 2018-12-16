package com.wubangzhu.domain.http.response.login;

import java.util.List;

public class GoodHistoryLIst extends BaseResponse{

    /**
     * code : 0
     * message : 成功
     * gwhistorys : [{"id":1,"userid":16,"gwshopmodelid":1,"picture":"http://192.168.2.109:9090/image/1.png","info":"1","name":"aa","price":22,"xa":0,"xb":0,"youfei":null,"paymoney":0,"paytime":1544198400000,"state":0,"kdmc":null,"kddh":null}]
     */

    private List<GwhistorysBean> gwhistorys;


    public List<GwhistorysBean> getGwhistorys() {
        return gwhistorys;
    }

    public void setGwhistorys(List<GwhistorysBean> gwhistorys) {
        this.gwhistorys = gwhistorys;
    }

    public static class GwhistorysBean {
        /**
         * id : 1
         * userid : 16
         * gwshopmodelid : 1
         * picture : http://192.168.2.109:9090/image/1.png
         * info : 1
         * name : aa
         * price : 22.0
         * xa : 0
         * xb : 0
         * youfei : null
         * paymoney : 0.0
         * paytime : 1544198400000
         * state : 0
         * kdmc : null
         * kddh : null
         */

        private int id;
        private int userid;
        private int gwshopmodelid;
        private String picture;
        private String info;
        private String name;
        private double price;
        private int xa;
        private int xb;
        private Object youfei;
        private double paymoney;
        private long paytime;
        private int state;
        private Object kdmc;
        private Object kddh;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }

        public int getGwshopmodelid() {
            return gwshopmodelid;
        }

        public void setGwshopmodelid(int gwshopmodelid) {
            this.gwshopmodelid = gwshopmodelid;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
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

        public Object getYoufei() {
            return youfei;
        }

        public void setYoufei(Object youfei) {
            this.youfei = youfei;
        }

        public double getPaymoney() {
            return paymoney;
        }

        public void setPaymoney(double paymoney) {
            this.paymoney = paymoney;
        }

        public long getPaytime() {
            return paytime;
        }

        public void setPaytime(long paytime) {
            this.paytime = paytime;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public Object getKdmc() {
            return kdmc;
        }

        public void setKdmc(Object kdmc) {
            this.kdmc = kdmc;
        }

        public Object getKddh() {
            return kddh;
        }

        public void setKddh(Object kddh) {
            this.kddh = kddh;
        }
    }
}
