package com.wubangzhu.domain.http.response.login;

public class UserInfoResponse extends BaseResponse{


    /**
     * user : {"id":16,"phonenumber":"13722852917","password":"e8ca4c1bcf298360bfa528f205df98f8","name":"13722852917","address":null,"state":0,"xa":0,"xb":0,"istg":0,"tgname":null}
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
         * id : 16
         * phonenumber : 13722852917
         * password : e8ca4c1bcf298360bfa528f205df98f8
         * name : 13722852917
         * address : null
         * state : 0
         * xa : 0
         * xb : 0
         * istg : 0
         * tgname : null
         */

        private int id;
        private String phonenumber;
        private String password;
        private String name;
        private Object address;
        private int state;
        private int xa;
        private int xb;
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
