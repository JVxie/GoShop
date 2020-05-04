package com.jvxie.goshop.mapper;

import com.jvxie.goshop.model.GoodsType;

import java.util.List;

public interface GoodsTypeMapper {
    int insert(GoodsType record);

    int insertSelective(GoodsType record);

    List<GoodsType> selectAll();
}