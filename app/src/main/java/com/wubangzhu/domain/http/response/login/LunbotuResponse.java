package com.wubangzhu.domain.http.response.login;

import java.util.List;

public class LunbotuResponse {

    /**
     * code : 0
     * message : ok
     * pictures : [{"id":1,"path":"http://localhost:9090/image/1.png","type":2,"state":2}]
     */

    private int code;
    private String message;
    private List<PicturesBean> pictures;

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

    public List<PicturesBean> getPictures() {
        return pictures;
    }

    public void setPictures(List<PicturesBean> pictures) {
        this.pictures = pictures;
    }

    public static class PicturesBean {
        /**
         * id : 1
         * path : http://localhost:9090/image/1.png
         * type : 2
         * state : 2
         */

        private int id;
        private String path;
        private int type;
        private int state;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }
    }
}
