package com.wubangzhu.domain.http.response.login;

import java.util.List;

public class AllGoods extends BaseResponse{

    /**
     * code : 0
     * message : 成功
     * shopmodels : [{"id":1,"name":"苹果XS黑色128G","price":"13000","total":"10","state":"1","toptypeid":1}]
     */

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
         * name : 苹果XS黑色128G
         * price : 13000
         * total : 10
         * state : 1
         * toptypeid : 1
         */

        private int id;
        private String name;
        private String price;
        private String total;
        private String state;
        private int toptypeid;

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

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public int getToptypeid() {
            return toptypeid;
        }

        public void setToptypeid(int toptypeid) {
            this.toptypeid = toptypeid;
        }
    }
}
