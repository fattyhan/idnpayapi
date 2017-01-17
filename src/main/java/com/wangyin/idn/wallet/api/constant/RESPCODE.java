package com.wangyin.idn.wallet.api.constant;

/**
 * Created by hanxiaofei on 2016/12/20.
 */
public enum RESPCODE {
    SUCCESS("JWP0000"),FAIL("JWP1000");
    private String desc;
    RESPCODE(String desc) {
        this.desc = desc;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
}
