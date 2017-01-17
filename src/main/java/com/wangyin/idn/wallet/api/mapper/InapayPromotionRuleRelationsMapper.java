package com.wangyin.idn.wallet.api.mapper;

import com.wangyin.idn.wallet.api.domain.InapayPromotionRuleRelations;
import org.apache.ibatis.annotations.*;

/**
 * Created by hanxiaofei on 2017/1/16.
 */
@Mapper
public interface InapayPromotionRuleRelationsMapper {
//    @Results(id = "userResult", value = {
//            @Result(property = "id", column = "uid", id = true),
//            @Result(property = "promotion_id", column = "promotion_id"),
//            @Result(property = "rule_type", column = "rule_type"),
//            @Result(property = "created_date", column = "created_date"),
//            @Result(property = "modified_date", column = "modified_date"),
//            @Result(property = "rule_id", column = "rule_id")
//    })
    @ResultType(InapayPromotionRuleRelations.class)
    @Select("select *  from inapay_promotion_rule_relations where id=#{id}")
    InapayPromotionRuleRelations getIPRById(@Param("id") String id);
}
