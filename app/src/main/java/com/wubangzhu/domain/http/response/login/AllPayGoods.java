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
         * id : 22
         * name : 苹果8黑色64G
         * price : 15000
         * picture : http://192.168.2.109:9090/image/1.png
         * picture1 : http://192.168.2.109:9090/image/1.png
         * picture2 : http://192.168.2.109:9090/image/1.png
         * picture3 : http://192.168.2.109:9090/image/1.png
         * total : 5
         * bmrs : 0
         * state : 1
         * createtime : 1544194440000
         * luckynumber : 5224.64
         * islucky : 0
         * shopmodelid : 2
         * luckyuserid : null
         * ghowtime : 0
         * gendtime : null
         * gwaittime : null
         * starttime : null
         */

        private int id;
        private String name;
        private String price;
        private String picture;
        private String picture1;
        private String picture2;
        private String picture3;
        private int total;
        private int bmrs;
        private int state;
        private long createtime;
        private double luckynumber;
        private String islucky;
        private int shopmodelid;
        private Object luckyuserid;
        private int ghowtime;
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

        public int getState() {
            return state;
        }

        public void setState(int state) {
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

        public int getGhowtime() {
            return ghowtime;
        }

        public void setGhowtime(int ghowtime) {
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
