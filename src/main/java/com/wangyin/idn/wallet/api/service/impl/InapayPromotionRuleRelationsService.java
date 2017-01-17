package com.wangyin.idn.wallet.api.service.impl;

import com.wangyin.idn.wallet.api.domain.InapayPromotionRuleRelations;
import com.wangyin.idn.wallet.api.mapper.InapayPromotionRuleRelationsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hanxiaofei on 2017/1/16.
 */
@Service
public class InapayPromotionRuleRelationsService {
    @Autowired
    private InapayPromotionRuleRelationsMapper inapayPromotionRuleRelationsMapper;
    @Transactional
    public InapayPromotionRuleRelations getIPR(String id){
        return inapayPromotionRuleRelationsMapper.getIPRById(id);
    }
}
