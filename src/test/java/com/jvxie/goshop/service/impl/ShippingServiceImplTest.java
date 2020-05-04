package com.jvxie.goshop.service.impl;

import com.jvxie.goshop.GoshopApplicationTests;
import com.jvxie.goshop.enums.ResponseEnum;
import com.jvxie.goshop.form.ShippingForm;
import com.jvxie.goshop.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class ShippingServiceImplTest extends GoshopApplicationTests {
    @Autowired
    private ShippingServiceImpl shippingServiceImpl;

    private Long userId = 123L;
    private ShippingForm form = new ShippingForm();

    @Before
    public void before() {
        form.setShippingName("JVxie");
        form.setShippingPhone("13067073579");
        form.setShippingProvince("福建省");
        form.setShippingCity("泉州市");
        form.setShippingDistrict("安溪县");
        form.setShippingAddress("第一大道");
        form.setShippingZip("362400");
    }

    @Test
    public void add() {

        ResponseVo responseVo = shippingServiceImpl.add(userId, form);
        log.info("res = {}", responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void delete() {
        ResponseVo responseVo = shippingServiceImpl.delete(userId, 706222739333316608L);
        log.info("res = {}", responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void update() {
        form.setShippingName("我不是药神");
        ResponseVo responseVo = shippingServiceImpl.update(userId, 706222909429121024L, form);
        log.info("res = {}", responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void list() {
        ResponseVo responseVo = shippingServiceImpl.list(userId, 1, 10);
        log.info("res = {}", responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}