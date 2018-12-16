package com.wubangzhu.domain.http.response.login;

import java.util.List;

public class AllGoods extends BaseResponse{


    private List<ShopmodelsBean> shopmodels;

    public List<ShopmodelsBean> getShopmodels() {
        return shopmodels;
    }

    public void setShopmodels(List<ShopmodelsBean> shopmodels) {
        this.shopmodels = shopmodels;
    }

    public static class ShopmodelsBean {
        /**
         * id : 1
         * type : 1
         * name : 苹果XS黑色128G
         * price : 13000
         * picture : http://192.168.2.109:9090/image/1.png
         * picture1 : http://192.168.2.109:9090/image/1.png
         * picture2 : http://192.168.2.109:9090/image/1.png
         * picture3 : http://192.168.2.109:9090/image/1.png
         * total : 2
         * luckyx : 3
         * state : 1
         * ghowtime : 30
         * gwaittime : null
         */

        private int id;
        private int type;
        private String name;
        private String price;
        private String picture;
        private String picture1;
        private String picture2;
        private String picture3;
        private int total;
        private int luckyx;
        private int state;
        private int ghowtime;
        private Object gwaittime;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
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

        public int getLuckyx() {
            return luckyx;
        }

        public void setLuckyx(int luckyx) {
            this.luckyx = luckyx;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public int getGhowtime() {
            return ghowtime;
        }

        public void setGhowtime(int ghowtime) {
            this.ghowtime = ghowtime;
        }

        public Object getGwaittime() {
            return gwaittime;
        }

        public void setGwaittime(Object gwaittime) {
            this.gwaittime = gwaittime;
        }
    }
}
