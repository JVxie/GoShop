package com.jvxie.goshop.service.impl;

import com.jvxie.goshop.mapper.GoodsTypeMapper;
import com.jvxie.goshop.model.GoodsType;
import com.jvxie.goshop.service.IGoodsTypeService;
import com.jvxie.goshop.vo.GoodsTypeVo;
import com.jvxie.goshop.vo.ResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.jvxie.goshop.constants.GoShopConstants.ROOT_PARENT_TYPE_ID;

@Service
public class GoodsTypeServiceImpl implements IGoodsTypeService {

    @Autowired
    GoodsTypeMapper goodsTypeMapper;

    @Override
    public ResponseVo< List<GoodsTypeVo> > selectAll() {
        List<GoodsType> goodsTypes = goodsTypeMapper.selectAll();

        /* 提取根目录 */
        List<GoodsTypeVo> goodsTypeVos = goodsTypes.stream().
                filter(e -> e.getParentTypeId().equals(ROOT_PARENT_TYPE_ID)).
                map(this::goodsTypes2GoodsTypeVo).
                collect(Collectors.toList());

        // 查找子目录
        findSubGoodsType(goodsTypeVos, goodsTypes);
        return ResponseVo.success(goodsTypeVos);
    }

    private void findSubGoodsType(List<GoodsTypeVo> goodsTypeVos, List<GoodsType> goodsTypes) {
        for (GoodsTypeVo goodsTypeVo : goodsTypeVos) {
            List<GoodsTypeVo> subGoodsTypeVos = goodsTypes.stream().
                    filter(e -> e.getParentTypeId().equals(goodsTypeVo.getGoodsTypeId())).
                    map(this::goodsTypes2GoodsTypeVo).
                    collect(Collectors.toList());
            findSubGoodsType(subGoodsTypeVos, goodsTypes);
            goodsTypeVo.setSubGoodsType(subGoodsTypeVos);
        }
    }

    private GoodsTypeVo goodsTypes2GoodsTypeVo(GoodsType goodsType) {
        GoodsTypeVo goodsTypeVo = new GoodsTypeVo();
        BeanUtils.copyProperties(goodsType, goodsTypeVo);
        return goodsTypeVo;
    }

    @Override
    public void findSubGoodsTypeId(Long goodsTypeId, Set<Long> goodsTypeIdSet) {
        List<GoodsType> goodsTypes = goodsTypeMapper.selectAll();
        findSubGoodsTypeId(goodsTypeId, goodsTypeIdSet, goodsTypes);
    }

    private void findSubGoodsTypeId(Long goodsTypeId, Set<Long> goodsTypeIdSet, List<GoodsType> goodsTypes) {
        for (GoodsType goodsType : goodsTypes) {
            if (goodsType.getParentTypeId().equals(goodsTypeId)) {
                goodsTypeIdSet.add(goodsType.getGoodsTypeId());
                findSubGoodsTypeId(goodsType.getGoodsTypeId(), goodsTypeIdSet, goodsTypes);
            }
        }
    }
}
