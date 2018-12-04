package com.wubangzhu.domain.http.response.login;

import java.util.List;

public class AllPayGoods extends BaseResponse{

    private List<OurGuessesBean> ourGuesses;

    public List<OurGuessesBean> getOurGuesses() {
        return ourGuesses;
    }

    public void setOurGuesses(List<OurGuessesBean> ourGuesses) {
        this.ourGuesses = ourGuesses;
    }

    public static class OurGuessesBean {
        /**
         * id : 3
         * name : 苹果8黑色64G
         * price : 15000
         * picur1 : 15000
         * total : 5
         * bmrs : 1 报名人数
         * state : 1 报名中1 报满2 猜完3
         * createtime : 1543248000000
         * luckynumber : 3707.19
         * islucky : 0 未猜中0 已猜中1
         * shopmodelid : 2
         * luckyuserid : null
         * ghowtime : null 游戏持续时间
         * gendtime : null 游戏结束时间
         * gwaittime : null 游戏开始后需loading时间
         * starttime : null 游戏开始时间
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
        private Object luckyuserid;
        private Object ghowtime;
        private Object gendtime;
        private Object gwaittime;
        private Object starttime;

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

        public Object getLuckyuserid() {
            return luckyuserid;
        }

        public void setLuckyuserid(Object luckyuserid) {
            this.luckyuserid = luckyuserid;
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

        public Object getGwaittime() {
            return gwaittime;
        }

        public void setGwaittime(Object gwaittime) {
            this.gwaittime = gwaittime;
        }

        public Object getStarttime() {
            return starttime;
        }

        public void setStarttime(Object starttime) {
            this.starttime = starttime;
        }
    }
}
