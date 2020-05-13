package com.jvxie.goshop.service;

import com.jvxie.goshop.form.ShopCarAddForm;
import com.jvxie.goshop.form.ShopCarUpdateForm;
import com.jvxie.goshop.model.ShopCar;
import com.jvxie.goshop.vo.ResponseVo;
import com.jvxie.goshop.vo.ShopCarVo;

import java.util.List;

public interface IShopCarService {
    ResponseVo<ShopCarVo> add(Long userId, ShopCarAddForm form);

    ResponseVo<ShopCarVo> list(Long userId);

    ResponseVo<ShopCarVo> update(Long userId, Long goodsId, ShopCarUpdateForm shopCarUpdateForm);

    ResponseVo<ShopCarVo> delete(Long userId, Long goodsId);

    ResponseVo<ShopCarVo> selectAll(Long userId);

    ResponseVo<ShopCarVo> unSelectAll(Long userId);

    ResponseVo<Integer> sum(Long userId);

    List<ShopCar> listForShopCar(Long userId);
}
