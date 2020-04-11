package com.jvxie.goshop.service;

import com.jvxie.goshop.vo.GoodsTypeVo;
import com.jvxie.goshop.vo.ResponseVo;

import java.util.List;

public interface IGoodsTypeService {

    ResponseVo<List<GoodsTypeVo>> selectAll();

}
