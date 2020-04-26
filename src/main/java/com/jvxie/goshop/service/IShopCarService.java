package com.jvxie.goshop.service;

import com.jvxie.goshop.form.ShopCarAddForm;
import com.jvxie.goshop.form.ShopCarUpdateForm;
import com.jvxie.goshop.vo.ResponseVo;

public interface IShopCarService {
    ResponseVo add(Long uid, ShopCarAddForm form);

    ResponseVo list(Long uid);

    ResponseVo update(Long uid, Long goodsId, ShopCarUpdateForm shopCarUpdateForm);

    ResponseVo delete(Long uid, Long goodsId);

    ResponseVo selectAll(Long uid);

    ResponseVo unSelectAll(Long uid);

    ResponseVo sum(Long uid);
}
