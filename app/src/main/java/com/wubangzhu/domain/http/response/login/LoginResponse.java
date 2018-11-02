package com.wubangzhu.domain.http.response.login;

public class LoginResponse {


    /**
     * code : 0
     * message : 登录成功！
     * ukey : 2351425
     * uid : 13
     */

    private int code;
    private String message;
    private String ukey;
    private int uid;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

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
