package com.wubangzhu.domain.http.response.login;

public class LoginResponse extends BaseResponse{


    /**
     * code : 0
     * message : 登录成功！
     * ukey : 2351425
     * uid : 13
     */

    private String ukey;
    private int uid;


    public String getUkey() {
        return ukey;
    }

    public void setUkey(String ukey) {
        this.ukey = ukey;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
