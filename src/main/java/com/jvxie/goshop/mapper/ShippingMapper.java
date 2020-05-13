package com.jvxie.goshop.mapper;

import com.jvxie.goshop.model.Shipping;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShippingMapper {
    int insert(Shipping record);

    int insertSelective(Shipping record);

    int deleteByShippingIdAndUserId(@Param("userId") Long userId,
                                    @Param("shippingId") Long shippingId);

    int updateByShippingId(Shipping record);

    List<Shipping> selectByUserId(Long userId);

    Shipping selectByUserIdAndShippingId(Long userId, Long shippingId);
}