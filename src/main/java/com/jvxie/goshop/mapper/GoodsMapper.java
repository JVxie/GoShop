package com.jvxie.goshop.mapper;

import com.jvxie.goshop.model.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface GoodsMapper {
    int insert(Goods record);

    int insertSelective(Goods record);

    /**
     * @param goodsTypeIdSet 注意要加{@Param}注解
     */
    List<Goods> selectByGoodsTypeIdSet(@Param("goodsTypeIdSet") Set<Long> goodsTypeIdSet);

    Goods selectByGoodsId(Long goodsId);

    List<Goods> selectByGoodsIdSet(@Param("goodsIdSet") Set<Long> goodsIdSet);
}