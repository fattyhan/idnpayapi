package com.wangyin.idn.wallet.api.constant;

/**
 * Created by hanxiaofei on 2016/12/19.
 */
public enum ERRCODE {
    JWP0001("risk filter"),JWP0002("param is not available"),JWP0003("system wrong"),JWP0004("sign not available");
    private String desc;
    ERRCODE(String desc) {
        this.desc = desc;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
}
