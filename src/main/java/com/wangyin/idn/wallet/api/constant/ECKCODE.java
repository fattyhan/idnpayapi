package com.wangyin.idn.wallet.api.constant;

/**
 * Created by hanxiaofei on 2016/12/19.
 * 风控核查接口
 */
public enum ECKCODE {
    ACCOUNT(1),AMOUNT(2),SELLER(3);
    private int desc;
    ECKCODE(int desc) {
        this.desc = desc;
    }
    public int getDesc() {
        return desc;
    }
    public void setDesc(int desc) {
        this.desc = desc;
    }
}
