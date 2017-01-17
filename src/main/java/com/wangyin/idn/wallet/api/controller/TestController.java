package com.wangyin.idn.wallet.api.controller;

import com.alibaba.fastjson.JSON;
import com.wangyin.idn.wallet.api.domain.InapayPromotionRuleRelations;
import com.wangyin.idn.wallet.api.service.impl.InapayPromotionRuleRelationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hanxiaofei on 2017/1/16.
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private InapayPromotionRuleRelationsService inapayPromotionRuleRelationsService;

    @RequestMapping("/getIDPR")
    @ResponseBody
    String getIDPR(String id){
        InapayPromotionRuleRelations inapayPromotionRuleRelations = inapayPromotionRuleRelationsService.getIPR(id);
        return JSON.toJSONString(inapayPromotionRuleRelations);
    }
}
