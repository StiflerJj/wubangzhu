package com.wubangzhu.util;

import java.util.ArrayList;
import java.util.List;

public class ShareKeys {
    /**
     * 测试图片地址
     */
    public static final List<String> images = new ArrayList<>();
    public static final String authorization = "authorization";
    public static final String Login_UserId = "userId";
    public static final String Login_UKEY = "ukey";

    public static ArrayList<String> getImages(){
        images.add("http://img4.imgtn.bdimg.com/it/u=1293919120,3114443152&fm=26&gp=0.jpg");
        images.add("http://img1.imgtn.bdimg.com/it/u=2486956696,687545127&fm=26&gp=0.jpg");
        images.add("http://img1.imgtn.bdimg.com/it/u=1193474556,1223904415&fm=26&gp=0.jpg");
        images.add("http://img5.imgtn.bdimg.com/it/u=49764040,3750999451&fm=26&gp=0.jpg");
        return (ArrayList<String>) images;
    }
}
