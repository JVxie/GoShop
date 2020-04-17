package com.jvxie.goshop.mapper;

import com.jvxie.goshop.model.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    /**
     * @param goodsTypeIdSet 注意要加{@Param}注解
     */
    List<Goods> selectByGoodsTypeIdSet(@Param("goodsTypeIdSet") Set<Long> goodsTypeIdSet);

    Goods selectByGoodsId(Long goodsId);
}