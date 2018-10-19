package com.wubangzhu.domain.http.response.login;

public class UserInfoResponse {

    /**
     * member : {"id":"100000002005","username":"zyxhy002","password":"","email":"1234@qq.com","mobilePhone":"18821875645","homePhone":"","idcard":"110105197303227893","idType":1,"pname":"钟南山","sex":1,"birthday":null,"enabled":1,"copd":1,"age":30,"memberType":0,"nickname":"钟经理","height":"175","weight":"93.8","intro":"","company":"中原","remark":"测试","doctorStatus":0,"memberOrgan":null,"doctorDeatil":null,"doctorOrganization":null,"displayName":"钟经理"}
     * status : 1
     */

    private MemberBean member;
    private int status;

    public MemberBean getMember() {
        return member;
    }

    public void setMember(MemberBean member) {
        this.member = member;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static class MemberBean {
        /**
         * id : 100000002005
         * username : zyxhy002
         * password :
         * email : 1234@qq.com
         * mobilePhone : 18821875645
         * homePhone :
         * idcard : 110105197303227893
         * idType : 1
         * pname : 钟南山
         * sex : 1
         * birthday : null
         * enabled : 1
         * copd : 1
         * age : 30
         * memberType : 0
         * nickname : 钟经理
         * height : 175
         * weight : 93.8
         * intro :
         * company : 中原
         * remark : 测试
         * doctorStatus : 0
         * memberOrgan : null
         * doctorDeatil : null
         * doctorOrganization : null
         * displayName : 钟经理
         */

        private String id;
        private String username;
        private String password;
        private String email;
        private String mobilePhone;
        private String homePhone;
        private String idcard;
        private int idType;
        private String pname;
        private int sex;
        private Object birthday;
        private int enabled;
        private int copd;
        private int age;
        private int memberType;
        private String nickname;
        private String height;
        private String weight;
        private String intro;
        private String company;
        private String remark;
        private int doctorStatus;
        private Object memberOrgan;
        private Object doctorDeatil;
        private Object doctorOrganization;
        private String displayName;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getMobilePhone() {
            return mobilePhone;
        }

        public void setMobilePhone(String mobilePhone) {
            this.mobilePhone = mobilePhone;
        }

        public String getHomePhone() {
            return homePhone;
        }

        public void setHomePhone(String homePhone) {
            this.homePhone = homePhone;
        }

        public String getIdcard() {
            return idcard;
        }

        public void setIdcard(String idcard) {
            this.idcard = idcard;
        }

        public int getIdType() {
            return idType;
        }

        public void setIdType(int idType) {
            this.idType = idType;
        }

        public String getPname() {
            return pname;
        }

        public void setPname(String pname) {
            this.pname = pname;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public Object getBirthday() {
            return birthday;
        }

        public void setBirthday(Object birthday) {
            this.birthday = birthday;
        }

        public int getEnabled() {
            return enabled;
        }

        public void setEnabled(int enabled) {
            this.enabled = enabled;
        }

        public int getCopd() {
            return copd;
        }

        public void setCopd(int copd) {
            this.copd = copd;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getMemberType() {
            return memberType;
        }

        public void setMemberType(int memberType) {
            this.memberType = memberType;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public int getDoctorStatus() {
            return doctorStatus;
        }

        public void setDoctorStatus(int doctorStatus) {
            this.doctorStatus = doctorStatus;
        }

        public Object getMemberOrgan() {
            return memberOrgan;
        }

        public void setMemberOrgan(Object memberOrgan) {
            this.memberOrgan = memberOrgan;
        }

        public Object getDoctorDeatil() {
            return doctorDeatil;
        }

        public void setDoctorDeatil(Object doctorDeatil) {
            this.doctorDeatil = doctorDeatil;
        }

        public Object getDoctorOrganization() {
            return doctorOrganization;
        }

        public void setDoctorOrganization(Object doctorOrganization) {
            this.doctorOrganization = doctorOrganization;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }
    }
}
