package com.wangyin.idn.wallet.api.domain;


import com.alibaba.fastjson.annotation.JSONField;

import java.sql.Timestamp;

/**
 * Created by hanxiaofei on 2017/1/16.
 */

public class InapayPromotionRuleRelations {
    private int id;
    private int promotion_id;
    private int rule_type;
    private Timestamp created_date;
    private Timestamp modified_date;
    private int rule_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPromotion_id() {
        return promotion_id;
    }

    public void setPromotion_id(int promotion_id) {
        this.promotion_id = promotion_id;
    }

    public int getRule_type() {
        return rule_type;
    }

    public void setRule_type(int rule_type) {
        this.rule_type = rule_type;
    }

    public Timestamp getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Timestamp created_date) {
        this.created_date = created_date;
    }

    public Timestamp getModified_date() {
        return modified_date;
    }

    public void setModified_date(Timestamp modified_date) {
        this.modified_date = modified_date;
    }

    public int getRule_id() {
        return rule_id;
    }

    public void setRule_id(int rule_id) {
        this.rule_id = rule_id;
    }
}