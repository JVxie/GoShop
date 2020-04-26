package com.jvxie.goshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jvxie.goshop.enums.IdGeneratorEnum;
import com.jvxie.goshop.enums.ResponseEnum;
import com.jvxie.goshop.mapper.GoodsMapper;
import com.jvxie.goshop.model.Goods;
import com.jvxie.goshop.service.IGoodsService;
import com.jvxie.goshop.utils.IdGeneratorUtil;
import com.jvxie.goshop.vo.GoodsDetailVo;
import com.jvxie.goshop.vo.GoodsVo;
import com.jvxie.goshop.vo.ResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.jvxie.goshop.enums.GoodsStatusEnum.DELETE;
import static com.jvxie.goshop.enums.GoodsStatusEnum.OFF_SALE;

@Service
public class GoodsServiceImpl implements IGoodsService {
    @Autowired
    GoodsTypeServiceImpl goodsTypeService;

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public ResponseVo<PageInfo> list(Long goodsTypeId, Integer pageNum, Integer pageSize) {
        Set<Long> goodsTypeIdSet = new HashSet<>();
        if (goodsTypeId != null) {
            goodsTypeService.findSubGoodsTypeId(goodsTypeId, goodsTypeIdSet);
            goodsTypeIdSet.add(goodsTypeId);
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Goods> goodsList = goodsMapper.selectByGoodsTypeIdSet(goodsTypeIdSet);
        List<GoodsVo> goodsVos = goodsList.stream()
                .map(e -> {
                    GoodsVo goodsVo = new GoodsVo();
                    BeanUtils.copyProperties(e, goodsVo);
                    return goodsVo;
                }).collect(Collectors.toList());
        PageInfo pageInfo = new PageInfo<>(goodsList);
        pageInfo.setList(goodsVos);
        return ResponseVo.success(pageInfo);
    }

    @Override
    public ResponseVo<GoodsDetailVo> detail(Long goodsId) {
        Goods goods = goodsMapper.selectByGoodsId(goodsId);
        if (goods == null) {
            return ResponseVo.error(ResponseEnum.GOODS_NOT_FOUND);
        }
        if (goods.getGoodsStatus().equals(OFF_SALE.getCode()) ||
                goods.getGoodsStatus().equals(DELETE.getCode())) {
            return ResponseVo.error(ResponseEnum.GOODS_OFF_SALE_OR_DELETE);
        }
        GoodsDetailVo goodsDetailVo = new GoodsDetailVo();
        BeanUtils.copyProperties(goods, goodsDetailVo);
        return ResponseVo.success(goodsDetailVo);
    }

    @Override
    public void insertGoods(Goods goods) {
        IdGeneratorUtil idGenerator = new IdGeneratorUtil(IdGeneratorEnum.GOODS);
        goods.setGoodsId(idGenerator.nextId());
        goodsMapper.insertSelective(goods);
    }
}
