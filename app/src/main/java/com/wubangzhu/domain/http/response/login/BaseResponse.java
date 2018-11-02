package com.wubangzhu.domain.http.response.login;

public class BaseResponse {


    /**
     * code : 0
     * message : 发送成功
     */

    private int code;
    private String message;

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
}
