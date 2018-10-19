package com.wubangzhu.domain.http.request.login;


import com.wubangzhu.util.Base64;

public class LoginRequest {

    String userName;
    String passWord;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "Basic " + Base64.encodeToString((getUserName() + ":" +
                getPassWord()).getBytes(),Base64.DEFAULT);
    }
}
