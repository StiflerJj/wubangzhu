package com.wubangzhu.domain.http.response.login;

import java.util.List;

public class AllMyHistoryBiao extends BaseResponse{

    private List<GuessjposBean> guessjpos;

    public List<GuessjposBean> getGuessjpos() {
        return guessjpos;
    }

    public void setGuessjpos(List<GuessjposBean> guessjpos) {
        this.guessjpos = guessjpos;
    }

    public static class GuessjposBean {
        /**
         * id : 15
         * name : 可乐
         * price : null
         * starttime : 1544107815000
         * ghowtime : null
         * gendtime : null
         * userid : null
         * luckynumber : 1111.0
         * state : null
         * shopmodelid : null
         * islucky : null
         */

        private int id;
        private String name;
        private Object price;
        private long starttime;
        private Object ghowtime;
        private Object gendtime;
        private Object userid;
        private double luckynumber;
        private Object state;
        private Object shopmodelid;
        private Object islucky;

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

        public Object getPrice() {
            return price;
        }

        public void setPrice(Object price) {
            this.price = price;
        }

        public long getStarttime() {
            return starttime;
        }

        public void setStarttime(long starttime) {
            this.starttime = starttime;
        }

        public Object getGhowtime() {
            return ghowtime;
        }

        public void setGhowtime(Object ghowtime) {
            this.ghowtime = ghowtime;
        }

        public Object getGendtime() {
            return gendtime;
        }

        public void setGendtime(Object gendtime) {
            this.gendtime = gendtime;
        }

        public Object getUserid() {
            return userid;
        }

        public void setUserid(Object userid) {
            this.userid = userid;
        }

        public double getLuckynumber() {
            return luckynumber;
        }

        public void setLuckynumber(double luckynumber) {
            this.luckynumber = luckynumber;
        }

        public Object getState() {
            return state;
        }

        public void setState(Object state) {
            this.state = state;
        }

        public Object getShopmodelid() {
            return shopmodelid;
        }

        public void setShopmodelid(Object shopmodelid) {
            this.shopmodelid = shopmodelid;
        }

        public Object getIslucky() {
            return islucky;
        }

        public void setIslucky(Object islucky) {
            this.islucky = islucky;
        }
    }
}
