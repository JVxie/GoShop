package com.jvxie.goshop.service.impl;

import com.jvxie.goshop.mapper.GoodsTypeMapper;
import com.jvxie.goshop.model.GoodsType;
import com.jvxie.goshop.service.IGoodsTypeService;
import com.jvxie.goshop.vo.GoodsTypeVo;
import com.jvxie.goshop.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsTypeServiceImpl implements IGoodsTypeService {

    @Autowired
    GoodsTypeMapper goodsTypeMapper;

    @Override
    public ResponseVo<List<GoodsTypeVo>> selectAll() {
        List<GoodsType> goodsTypes = goodsTypeMapper.selectAll();
        return null;
    }
}
