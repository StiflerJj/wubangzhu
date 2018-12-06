package com.wubangzhu.domain.http.response.login;

import java.util.List;

public class AllMyBiao extends BaseResponse{

    private List<OurGuessesBean> ourGuesses;

    public List<OurGuessesBean> getOurGuesses() {
        return ourGuesses;
    }

    public void setOurGuesses(List<OurGuessesBean> ourGuesses) {
        this.ourGuesses = ourGuesses;
    }

    public static class OurGuessesBean {
        /**
         * id : 5
         * name : 可乐
         * price : 5
         * picur1 : 5
         * total : 2
         * bmrs : 1
         * state : 2
         * createtime : 1544025600000
         * luckynumber : 8947.76
         * islucky : 0
         * shopmodelid : 4
         * luckyuserid : 2
         * ghowtime : 30
         * gendtime : 1544025600000
         * gwaittime : 30
         * starttime : 1544025600000
         */

        private int id;
        private String name;
        private String price;
        private String picur1;
        private int total;
        private int bmrs;
        private String state;
        private long createtime;
        private double luckynumber;
        private String islucky;
        private int shopmodelid;
        private int luckyuserid;
        private int ghowtime;
        private long gendtime;
        private int gwaittime;
        private long starttime;

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

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getPicur1() {
            return picur1;
        }

        public void setPicur1(String picur1) {
            this.picur1 = picur1;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getBmrs() {
            return bmrs;
        }

        public void setBmrs(int bmrs) {
            this.bmrs = bmrs;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public long getCreatetime() {
            return createtime;
        }

        public void setCreatetime(long createtime) {
            this.createtime = createtime;
        }

        public double getLuckynumber() {
            return luckynumber;
        }

        public void setLuckynumber(double luckynumber) {
            this.luckynumber = luckynumber;
        }

        public String getIslucky() {
            return islucky;
        }

        public void setIslucky(String islucky) {
            this.islucky = islucky;
        }

        public int getShopmodelid() {
            return shopmodelid;
        }

        public void setShopmodelid(int shopmodelid) {
            this.shopmodelid = shopmodelid;
        }

        public int getLuckyuserid() {
            return luckyuserid;
        }

        public void setLuckyuserid(int luckyuserid) {
            this.luckyuserid = luckyuserid;
        }

        public int getGhowtime() {
            return ghowtime;
        }

        public void setGhowtime(int ghowtime) {
            this.ghowtime = ghowtime;
        }

        public long getGendtime() {
            return gendtime;
        }

        public void setGendtime(long gendtime) {
            this.gendtime = gendtime;
        }

        public int getGwaittime() {
            return gwaittime;
        }

        public void setGwaittime(int gwaittime) {
            this.gwaittime = gwaittime;
        }

        public long getStarttime() {
            return starttime;
        }

        public void setStarttime(long starttime) {
            this.starttime = starttime;
        }
    }
}
