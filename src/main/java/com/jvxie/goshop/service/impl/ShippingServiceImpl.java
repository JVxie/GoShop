package com.jvxie.goshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jvxie.goshop.enums.IdGeneratorEnum;
import com.jvxie.goshop.enums.ResponseEnum;
import com.jvxie.goshop.form.ShippingForm;
import com.jvxie.goshop.mapper.ShippingMapper;
import com.jvxie.goshop.model.Shipping;
import com.jvxie.goshop.service.IShippingService;
import com.jvxie.goshop.utils.IdGeneratorUtil;
import com.jvxie.goshop.vo.GoodsVo;
import com.jvxie.goshop.vo.ResponseVo;
import com.jvxie.goshop.vo.ShippingVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ShippingServiceImpl implements IShippingService {
    @Autowired
    private ShippingMapper shippingMapper;

    @Override
    public ResponseVo add(Long userId, ShippingForm form) {
        Shipping shipping = new Shipping();
        BeanUtils.copyProperties(form, shipping);
        IdGeneratorUtil idGeneratorUtil = new IdGeneratorUtil(IdGeneratorEnum.SHIPPING);
        shipping.setShippingId(idGeneratorUtil.nextId());
        shipping.setUserId(userId);
        int row = shippingMapper.insertSelective(shipping);
        if (row == 0) {
            return ResponseVo.error(ResponseEnum.FAIL);
        }
        Map<String, Long> map = new HashMap<>();
        map.put("shippingId", shipping.getShippingId());
        return ResponseVo.success(map);
    }

    @Override
    public ResponseVo delete(Long userId, Long shippingId) {
        int row = shippingMapper.deleteByShippingIdAndUserId(userId, shippingId);
        if (row == 0) {
            return ResponseVo.error(ResponseEnum.FAIL);
        }
        return ResponseVo.success();
    }

    @Override
    public ResponseVo update(Long userId, Long shippingId, ShippingForm form) {
        Shipping shipping = new Shipping();
        BeanUtils.copyProperties(form, shipping);
        shipping.setUserId(userId);
        shipping.setShippingId(shippingId);
        int row = shippingMapper.updateByShippingId(shipping);
        if (row == 0) {
            return ResponseVo.error(ResponseEnum.FAIL);
        }
        return ResponseVo.success();
    }

    @Override
    public ResponseVo<PageInfo> list(Long userId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Shipping> shippingList = shippingMapper.selectByUserId(userId);
        List<ShippingVo> shippingVos = shippingList.stream()
                .map(e -> {
                    ShippingVo shippingVo = new ShippingVo();
                    BeanUtils.copyProperties(e, shippingVo);
                    return shippingVo;
                }).collect(Collectors.toList());
        PageInfo pageInfo = new PageInfo(shippingList);
        pageInfo.setList(shippingVos);
        return ResponseVo.success(pageInfo);
    }
}
