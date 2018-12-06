package com.wubangzhu.domain.http.response.login;

import java.util.List;

public class DanmuResponse {

    /**
     * code : 0
     * message : ok
     * notices : [{"id":2,"title":"恭喜","conbody":"小李上周收益1000元","type":2,"state":2}]
     */

    private int code;
    private String message;
    private List<NoticesBean> notices;

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

    public List<NoticesBean> getNotices() {
        return notices;
    }

    public void setNotices(List<NoticesBean> notices) {
        this.notices = notices;
    }

    public static class NoticesBean {
        /**
         * id : 2
         * title : 恭喜
         * conbody : 小李上周收益1000元
         * type : 2
         * state : 2
         */

        private int id;
        private String title;
        private String conbody;
        private int type;
        private int state;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getConbody() {
            return conbody;
        }

        public void setConbody(String conbody) {
            this.conbody = conbody;
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
