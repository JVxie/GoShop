package com.jvxie.goshop.service;

import com.github.pagehelper.PageInfo;
import com.jvxie.goshop.model.Goods;
import com.jvxie.goshop.vo.GoodsDetailVo;
import com.jvxie.goshop.vo.ResponseVo;

public interface IGoodsService {
    ResponseVo<PageInfo> list(Long goodsTypeId, Integer pageNum, Integer pageSize);

    ResponseVo<GoodsDetailVo> detail(Long goodsId);
}
