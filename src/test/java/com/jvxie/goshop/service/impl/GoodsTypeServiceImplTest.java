package com.jvxie.goshop.service.impl;

import com.jvxie.goshop.GoshopApplicationTests;
import com.jvxie.goshop.model.GoodsType;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class GoodsTypeServiceImplTest extends GoshopApplicationTests {

    @Autowired
    GoodsTypeServiceImpl goodsTypeService;

    @Test
    public void insertGoodType() {
        int MAX_N = 6;
        GoodsType[] goodsTypes = new GoodsType[MAX_N];
        for (int i = 0; i < MAX_N; ++i)
            goodsTypes[i] = new GoodsType();
        /*
            服饰 699286295570153472L
                男装 699288459445141504L
                    男上装 699289030684180480L
                    男裤装 699289031061667840L
                    运动鞋 699289031082639360L
                    板鞋 699289031107805184L
                    皮鞋 699289031128776704L
                女装 699288459860377600L
                    女上装 699289754000293888L
                    女裤装 699289754398752768L
                    内衣 699289754419724288L
                    女裙 699289754444890112L
                    运动鞋 699289754465861632L
                    高跟鞋 699289754486833152L
                饰品 699288459889737728L
                    手表 699300218742636544L
                    首饰 699300219443085312L
                    手饰 699300219468251136L
                    耳钉/耳环 699300219493416960L
                    眼镜 699300219514388480L
            箱包 699286295964418048L
                旅行箱 699299617703067648L
                钱包 699299618114109440L
                双肩包 699299618135080960L
                邮差包 699299618160246784L
                胸包 699299618177024000L
                手提包 699299618197995520
            数码产品 699286296002166784L
            食品 699286296060887040L
            医药保健 699286296094441472L
            图书音像 699286296115412992L
         */
        goodsTypes[0].setGoodsTypeName("手表");
        goodsTypes[0].setParentTypeId(699288459889737728L);
        goodsTypes[1].setGoodsTypeName("首饰");
        goodsTypes[1].setParentTypeId(699288459889737728L);
        goodsTypes[2].setGoodsTypeName("手饰");
        goodsTypes[2].setParentTypeId(699288459889737728L);
        goodsTypes[3].setGoodsTypeName("耳钉/耳环");
        goodsTypes[3].setParentTypeId(699288459889737728L);
        goodsTypes[4].setGoodsTypeName("眼镜");
        goodsTypes[4].setParentTypeId(699288459889737728L);
//        for (int i= 0; i < MAX_N; ++i)
//            goodsTypeService.insertGoodsType(goodsTypes[i]);
    }

    @Test
    public void findSubGoodsTypeId() {
        Set<Long> set = new HashSet<>();
        goodsTypeService.findSubGoodsTypeId(699286295570153472L, set);
        log.info("set = {}", set);
    }
}