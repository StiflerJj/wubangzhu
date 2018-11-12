package com.wubangzhu.domain.http.response.login;

public class StartShopResponse extends BaseResponse{


    /**
     * shmhistory : {"id":14,"starttime":1541771317632,"userid":13,"luckynumber":4028.72,"shopmodelid":1,"islucky":"0"}
     */

    private ShmhistoryBean shmhistory;

    public ShmhistoryBean getShmhistory() {
        return shmhistory;
    }

    public void setShmhistory(ShmhistoryBean shmhistory) {
        this.shmhistory = shmhistory;
    }

    public static class ShmhistoryBean {
        /**
         * id : 14
         * starttime : 1541771317632
         * userid : 13
         * luckynumber : 4028.72
         * shopmodelid : 1
         * islucky : 0
         */

        private int id;
        private long starttime;
        private int userid;
        private double luckynumber;
        private int shopmodelid;
        private String islucky;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public long getStarttime() {
            return starttime;
        }

        public void setStarttime(long starttime) {
            this.starttime = starttime;
        }

        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }

        public double getLuckynumber() {
            return luckynumber;
        }

        public void setLuckynumber(double luckynumber) {
            this.luckynumber = luckynumber;
        }

        public int getShopmodelid() {
            return shopmodelid;
        }

        public void setShopmodelid(int shopmodelid) {
            this.shopmodelid = shopmodelid;
        }

        public String getIslucky() {
            return islucky;
        }

        public void setIslucky(String islucky) {
            this.islucky = islucky;
        }
    }
}
