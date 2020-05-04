package com.jvxie.goshop.service;

import com.jvxie.goshop.form.ShopCarAddForm;
import com.jvxie.goshop.form.ShopCarUpdateForm;
import com.jvxie.goshop.vo.ResponseVo;

public interface IShopCarService {
    ResponseVo add(Long userId, ShopCarAddForm form);

    ResponseVo list(Long userId);

    ResponseVo update(Long userId, Long goodsId, ShopCarUpdateForm shopCarUpdateForm);

    ResponseVo delete(Long userId, Long goodsId);

    ResponseVo selectAll(Long userId);

    ResponseVo unSelectAll(Long userId);

    ResponseVo sum(Long userId);
}
