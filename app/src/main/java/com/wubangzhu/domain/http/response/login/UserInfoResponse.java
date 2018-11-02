package com.wubangzhu.domain.http.response.login;

public class UserInfoResponse extends BaseResponse{


    /**
     * code : 0
     * message : 请求成功
     * user : {"id":13,"phonenumber":"13722852917","password":"ffd0dac854eecfb5ce080c5ce722125b","name":"13722852917","address":null,"state":0,"coin":0,"istg":0,"tgname":null}
     */

    private UserBean user;


    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class UserBean {
        /**
         * id : 13
         * phonenumber : 13722852917
         * password : ffd0dac854eecfb5ce080c5ce722125b
         * name : 13722852917
         * address : null
         * state : 0
         * coin : 0
         * istg : 0
         * tgname : null
         */

        private int id;
        private String phonenumber;
        private String password;
        private String name;
        private Object address;
        private int state;
        private int coin;
        private int istg;
        private Object tgname;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPhonenumber() {
            return phonenumber;
        }

        public void setPhonenumber(String phonenumber) {
            this.phonenumber = phonenumber;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getAddress() {
            return address;
        }

        public void setAddress(Object address) {
            this.address = address;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public int getCoin() {
            return coin;
        }

        public void setCoin(int coin) {
            this.coin = coin;
        }

        public int getIstg() {
            return istg;
        }

        public void setIstg(int istg) {
            this.istg = istg;
        }

        public Object getTgname() {
            return tgname;
        }

        public void setTgname(Object tgname) {
            this.tgname = tgname;
        }
    }
}
