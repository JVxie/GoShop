package com.jvxie.goshop.service;

import com.jvxie.goshop.model.GoodsType;
import com.jvxie.goshop.vo.GoodsTypeVo;
import com.jvxie.goshop.vo.ResponseVo;

import java.util.List;
import java.util.Set;

public interface IGoodsTypeService {

    ResponseVo<List<GoodsTypeVo>> selectAll();

    void insertGoodsType(GoodsType goodsType);

    void findSubGoodsTypeId(Long goodsTypeId, Set<Long> goodsTypeIdSet);
}
