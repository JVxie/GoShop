# GoShop - 基于SpringBoot框架的简单电商系统

目前正处于客户端开发状态（**beta**）

> 一些相关版本信息：
>
> * SpringBoot（含SpringMVC、thymeleaf） v2.1.7
> * MySQL v8.0.19
> * Mybatis-starter v2.1.2
> * PageHelper-starter v1.2.13
> * Redis（on windows） v3.2  

下面展示当前已开发API（请求、返回示例）

## 一、用户模块（User）

### 1. 注册功能（Register）

*注：用户名(user_name)字段可为空，默认使用用户+生成的uid为用户名。*

- **POST** /user/register/registerByPhone

    *通过手机号注册用户*

    >*request*
    >
    >```json
    >{
    >    "user_name": "test1",
    >    "user_psw": "123456a",
    >    "user_phone": "18050861803",
    >    "user_sex": "3"
    >}
    >```
    >
    >*response*
    >
    >- success
    >
    >```json
    >{
    >    "status": 0,
    >    "msg": "成功"
    >}
    >```
    >
    >- failed
    >
    >```json
    >{
    >    "status": 2,
    >    "msg": "手机号已注册"
    >}
    >```
    >
    >```json
    >{
    >    "status": 11,
    >    "msg": "手机号不能为空"
    >}
    >```
    >
    >```json
    >{
    >    "status": 14,
    >    "msg": "用户已经登录"
    >}
    >```



- **POST** /user/register/registerByEmail

    *通过电子邮箱注册用户*

    >*request*
    >
    >```json
    >{
    >    "user_name": "test2",
    >    "user_psw": "123456a",
    >    "user_email": "test@test.test",
    >    "user_sex": "3"
    >}
    >```
    >
    >*response*
    >
    >- success
    >
    >```json
    >{
    >    "status": 0,
    >    "msg": "成功"
    >}
    >```
    >
    >- failed
    >
    >```json
    >{
    >    "status": 3,
    >    "msg": "邮箱已注册"
    >}
    >```
    >
    >```json
    >{
    >    "status": 11,
    >    "msg": "邮箱不能为空"
    >}
    >```
    >
    >```json
    >{
    >    "status": 14,
    >    "msg": "用户已经登录"
    >}
    >```

### 2. 登录功能（Login）

* **POST** /user/login

    *使用手机号或邮箱登录*

    >*request*
    >
    >```json
    >{
    >    "login_name": "18050861803",
    >    "user_psw": "123456a"
    >}
    >```
    >
    >response
    >
    >- success
    >
    >```json
    >{
    >    "status": 0,
    >    "data": {
    >       "id": 11,
    >       "user_id": 704003579786559488,
    >       "user_name": "test1",
    >       "user_psw": "",
    >       "user_group_id": 1,
    >       "user_sex": 3,
    >       "real_name": null,
    >       "user_phone": "18050861803",
    >       "user_email": null,
    >       "user_question": null,
    >       "user_answer": null,
    >       "last_login_time": null,
    >       "last_login_ip": null,
    >       "create_time": "2020-04-26T08:18:53.000+0000",
    >       "update_time": "2020-04-26T08:18:53.000+0000",
    >       "delete_time": null
    >    }
    >}
    >```
    >
    >还会返回一个Cookie，内容为`token={uid}; path=/; HttpOnly; Expires={NowTime+3days};`
    >
    >- failed
    >
    >```json
    >{
    >    "status": 12,
    >    "msg": "登录名或密码错误"
    >}
    >```
    >
    >```json
    >{
    >    "status": 14,
    >    "msg": "用户已经登录"
    >}
    >```

- **GET** /user/logout

    *用户登出*

    >*request*
    >
    >```json
    >无参数，需要先登录
    >```
    >
    >*response*
    >
    >- success
    >
    >```json
    >{
    >    "status": 0,
    >    "msg": "成功"
    >}
    >```
    >
    >- failed
    >
    >```json
    >{
    >    "status": 10,
    >    "msg": "用户未登录，请先登录"
    >}
    >```

###  3. 用户详情页功能

- **GET** /user

    *访问当前登录用户详情页*

    >*request*
    >
    >```json
    >无参数，需要先登录
    >```
    >
    >response
    >
    >- success
    >
    >```json
    >{
    >    "status": 0,
    >    "data": {
    >        "id": 11,
    >        "user_id": 704003579786559488,
    >        "user_name": "test1",
    >        "user_psw": "",
    >        "user_group_id": 1,
    >        "user_sex": 3,
    >        "real_name": null,
    >        "user_phone": "18050861803",
    >        "user_email": null,
    >        "user_question": null,
    >        "user_answer": null,
    >        "last_login_time": null,
    >        "last_login_ip": null,
    >        "create_time": "2020-04-26T08:18:53.000+0000",
    >        "update_time": "2020-04-26T08:18:53.000+0000",
    >        "delete_time": null
    >    }
    >}
    >```
    >
    >- failed
    >
    >```json
    >{
    >    "status": 10,
    >    "msg": "用户未登录，请先登录"
    >}
    >```

## 二、 商品模块（Goods）

### 1. 商品分类功能（GoodsType）

- **GET** /goodsType

    *获取所有商品类别*

    >*request*
    >
    >```json
    >无参数
    >```
    >
    >response
    >
    >```json
    >{
    >    "status": 0,
    >    "data": [
    >        {
    >            "goods_type_id": 699286295570153472,
    >            "parent_type_id": 0,
    >            "goods_type_name": "服饰",
    >            "goods_type_status": 1,
    >            "goods_type_sort": 0,
    >            "sub_goods_type": [
    >                {
    >                    "goods_type_id": 699288459445141504,
    >                    "parent_type_id": 699286295570153472,
    >                    "goods_type_name": "男装",
    >                    "goods_type_status": 1,
    >                    "goods_type_sort": 0,
    >                    "sub_goods_type": [
    >                        {
    >                            "goods_type_id": 699289030684180480,
    >                            "parent_type_id": 699288459445141504,
    >                            "goods_type_name": "男上装",
    >                            "goods_type_status": 1,
    >                            "goods_type_sort": 0,
    >                            "sub_goods_type": [...]
    >                        },
    >                        ...
    >                    ]
    >                },
    >                {
    >                    "goods_type_id": 699288459860377600,
    >                    "parent_type_id": 699286295570153472,
    >                    "goods_type_name": "女装",
    >                    "goods_type_status": 1,
    >                    "goods_type_sort": 0,
    >                    "sub_goods_type": [
    >                        {
    >                            "goods_type_id": 699289754000293888,
    >                            "parent_type_id": 699288459860377600,
    >                            "goods_type_name": "女上装",
    >                            "goods_type_status": 1,
    >                            "goods_type_sort": 0,
    >                            "sub_goods_type": [...]
    >                        },
    >                        ...
    >                    ]
    >                },
    >                ...
    >            ]
    >        },
    >        {
    >            "goods_type_id": 699286295964418048,
    >            "parent_type_id": 0,
    >            "goods_type_name": "箱包",
    >            "goods_type_status": 1,
    >            "goods_type_sort": 0,
    >            "sub_goods_type": [...]
    >        },
    >        ...
    >    ]
    >}
    >```

### 2. 商品信息功能

- **GET** /goods

    *获取商品列表（分页显示），三个参数都可为空*

    *`goodsTypeId`为空时默认所有类别，`pageNum`默认值为`1`，`pageSize`默认值为`10`*

    >*request*
    >
    >```json
    >goodsTypeId = null
    >pageNum = null
    >pageSize = null
    >```
    >
    >*response*
    >
    >```json
    >{
    >    "status": 0,
    >    "data": {
    >        "total": 5,
    >        "list": [
    >            {
    >                "goods_id": 700015772776267776,
    >                "goods_title": "男士黑色T恤",
    >                "goods_type_id": 699289030684180480,
    >                "goods_price": 10.00,
    >                "goods_status": 1,
    >                "goods_count": 10,
    >                "goods_img": null
    >            },
    >            {
    >                "goods_id": 700017327432794112,
    >                "goods_title": "男士白色T恤",
    >                "goods_type_id": 699289030684180480,
    >                "goods_price": 10.00,
    >                "goods_status": 1,
    >                "goods_count": 16,
    >                "goods_img": null
    >            },
    >            {
    >                "goods_id": 700017327827058688,
    >                "goods_title": "女士黄色连衣裙",
    >                "goods_type_id": 699288459860377600,
    >                "goods_price": 10.00,
    >                "goods_status": 1,
    >                "goods_count": 10,
    >                "goods_img": null
    >            },
    >            {
    >                "goods_id": 700017327848030208,
    >                "goods_title": "G-SHOCK 黑金时尚电子手表",
    >                "goods_type_id": 699300218742636544,
    >                "goods_price": 10.00,
    >                "goods_status": 1,
    >                "goods_count": 105,
    >                "goods_img": null
    >            },
    >            {
    >                "goods_id": 700017327869001728,
    >                "goods_title": "可口可乐500ml",
    >                "goods_type_id": 699286296060887040,
    >                "goods_price": 10.00,
    >                "goods_status": 1,
    >                "goods_count": 100,
    >                "goods_img": null
    >            }
    >        ],
    >        "page_num": 1,
    >        "page_size": 10,
    >        "size": 5,
    >        "start_row": 1,
    >        "end_row": 5,
    >        "pages": 1,
    >        "pre_page": 0,
    >        "next_page": 0,
    >        "is_first_page": true,
    >        "is_last_page": true,
    >        "has_previous_page": false,
    >        "has_next_page": false,
    >        "navigate_pages": 8,
    >        "navigatepage_nums": [
    >            1
    >        ],
    >        "navigate_first_page": 1,
    >        "navigate_last_page": 1
    >    }
    >}
    >```

* **GET** /goods/{goodsId}

    *获取指定商品详情*

    > *request*
    >
    > ```json
    > goodsId = 700017327869001728
    > ```
    >
    > *response*
    >
    > - success
    >
    > ```json
    > {
    >     "status": 0,
    >     "data": {
    >         "goods_id": 700017327869001728,
    >         "goods_title": "可口可乐500ml",
    >         "goods_type_id": 699286296060887040,
    >         "goods_old_price": 10.00,
    >         "goods_price": 10.00,
    >         "goods_status": 1,
    >         "goods_count": 100,
    >         "goods_img": null,
    >         "goods_detail": null
    >     }
    > }
    > ```
    >
    > - failed
    >
    > ```json
    > {
    >     "status": 4,
    >     "msg": "商品不存在"
    > }
    > ```
    >
    > ```json
    > {
    >     "status": 5,
    >     "msg": "商品下架或删除"
    > }
    > ```

## 三、 购物车模块（ShopCar）

*注：以下所有功能需要先登录。*

### 1. 购物车详情功能

* **GET** /shopCar

    *获取购物车内所有商品信息*

    >*request*
    >
    >```json
    >无参数
    >```
    >
    >*response*
    >
    >```json
    >{
    >    "status": 0,
    >    "data": {
    >        "shop_car_goods_vo_list": [
    >            {
    >                "goods_id": 700017327848030208,
    >                "quantity": 2,
    >                "goods_title": "G-SHOCK 黑金时尚电子手表",
    >                "goods_img": null,
    >                "goods_price": 10.00,
    >                "goods_status": 1,
    >                "goods_total_price": 20.00,
    >                "goods_count": 105,
    >                "selected": true
    >            },
    >            {
    >                "goods_id": 700017327869001728,
    >                "quantity": 5,
    >                "goods_title": "可口可乐500ml",
    >                "goods_img": null,
    >                "goods_price": 10.00,
    >                "goods_status": 1,
    >                "goods_total_price": 50.00,
    >                "goods_count": 100,
    >                "selected": true
    >            }
    >        ],
    >        "select_all": true,
    >        "shop_car_total_price": 70.00,
    >        "shop_car_total_quantity": 7
    >    }
    >}
    >```

### 2. 购物车内商品增删改功能

* **POST** /shopCar

    *往购物车内添加指定商品，`goods_id`必填，`selected`默认为`true`，`quantity`默认为`1`*

    >*request*
    >
    >```json
    >{
    >    "goods_id": 700017327869001728,
    >    "selected": true,
    >    "quantity": 1
    >}
    >```
    >
    >*response*
    >
    >- success
    >
    >```json
    >{
    >    "status": 0,
    >    "data": {
    >       "shop_car_goods_vo_list": [
    >            {
    >                "goods_id": 700017327848030208,
    >                "quantity": 2,
    >                "goods_title": "G-SHOCK 黑金时尚电子手表",
    >                "goods_img": null,
    >                "goods_price": 10.00,
    >                "goods_status": 1,
    >                "goods_total_price": 20.00,
    >                "goods_count": 105,
    >                "selected": true
    >            },
    >            {
    >                "goods_id": 700017327869001728,
    >                "quantity": 5,
    >                "goods_title": "可口可乐500ml",
    >                "goods_img": null,
    >                "goods_price": 10.00,
    >                "goods_status": 1,
    >                "goods_total_price": 50.00,
    >                "goods_count": 100,
    >                "selected": true
    >            }
    >        ],
    >        "select_all": true,
    >        "shop_car_total_price": 70.00,
    >        "shop_car_total_quantity": 7
    >    }
    >}
    >```
    >
    >- failed
    >
    >```json
    >{
    >    "status": 4,
    >    "msg": "商品不存在"
    >}
    >```
    >
    >```json
    >{
    >    "status": 5,
    >    "msg": "商品下架或删除"
    >}
    >```
    >
    >```json
    >{
    >    "status": 6,
    >    "msg": "商品库存不正确"
    >}
    >```
    >
    >```json
    >{
    >    "status": 7,
    >    "msg": "购物车最多可添加120件商品，请清理后添加"
    >}
    >```

- **PUT** /shopCar/{goodsId}

    *修改购物车内某商品信息，`goodsId`不可为空，`quantity`、`selected`为空时默认不修改*

    >*request*
    >
    >```json
    >{
    >    "quantity": 1,
    >    "selected": false
    >}
    >```
    >
    >*response*
    >
    >- success
    >
    >```json
    >{
    >    "status": 0,
    >    "data": {
    >       "shop_car_goods_vo_list": [
    >            {
    >                "goods_id": 700017327848030208,
    >                "quantity": 1,
    >                "goods_title": "G-SHOCK 黑金时尚电子手表",
    >                "goods_img": null,
    >                "goods_price": 10.00,
    >                "goods_status": 1,
    >                "goods_total_price": 10.00,
    >                "goods_count": 105,
    >                "selected": false
    >            },
    >            {
    >                "goods_id": 700017327869001728,
    >                "quantity": 5,
    >                "goods_title": "可口可乐500ml",
    >                "goods_img": null,
    >                "goods_price": 10.00,
    >                "goods_status": 1,
    >                "goods_total_price": 50.00,
    >                "goods_count": 100,
    >                "selected": true
    >            }
    >        ],
    >        "select_all": false,
    >        "shop_car_total_price": 50.00,
    >        "shop_car_total_quantity": 6
    >    }
    >}
    >```
    >
    >- failed
    >
    >```json
    >{
    >    "status": 6,
    >    "msg": "商品库存不正确"
    >}
    >```
    >
    >```json
    >{
    >    "status": 8,
    >    "msg": "购物车内无此商品，不可修改"
    >}
    >```
    
- **DELETE** /shopCar/{goodsId}

    *删除购物车内某商品，`goodsId`不可为空*

    >*request*
    >
    >```json
    >goodsId = 700017327848030208
    >```
    >
    >*response*
    >
    >- success
    >
    >```json
    >{
    >    "status": 0,
    >    "data": {
    >        "shop_car_goods_vo_list": [
    >            {
    >                "goods_id": 700017327869001728,
    >                "quantity": 5,
    >                "goods_title": "可口可乐500ml",
    >                "goods_img": null,
    >                "goods_price": 10.00,
    >                "goods_status": 1,
    >                "goods_total_price": 50.00,
    >                "goods_count": 100,
    >                "selected": true
    >            }
    >        ],
    >        "select_all": true,
    >        "shop_car_total_price": 50.00,
    >        "shop_car_total_quantity": 5
    >    }
    >}
    >```
    >
    >```json
    >{
    >    "status": 8,
    >    "msg": "购物车内无此商品，不可修改"
    >}
    >```

### 3. 购物车商品全（不）选功能

- **PUT** /shopCar/selectAll

    >*request*
    >
    >```json
    >无参数
    >```
    >
    >*response*
    >
    >```json
    >{
    >    "status": 0,
    >    "data": {
    >        "shop_car_goods_vo_list": [
    >            {
    >                "goods_id": 700017327848030208,
    >                "quantity": 1,
    >                "goods_title": "G-SHOCK 黑金时尚电子手表",
    >                "goods_img": null,
    >                "goods_price": 10.00,
    >                "goods_status": 1,
    >                "goods_total_price": 10.00,
    >                "goods_count": 105,
    >                "selected": true
    >            },
    >            {
    >                "goods_id": 700017327869001728,
    >                "quantity": 5,
    >                "goods_title": "可口可乐500ml",
    >                "goods_img": null,
    >                "goods_price": 10.00,
    >                "goods_status": 1,
    >                "goods_total_price": 50.00,
    >                "goods_count": 100,
    >                "selected": true
    >            }
    >        ],
    >        "select_all": true,
    >        "shop_car_total_price": 60.00,
    >        "shop_car_total_quantity": 6
    >    }
    >}
    >```

- **PUT** /shopCar/unSelecetAll

    >*request*
    >
    >```json
    >无参数
    >```
    >
    >*response*
    >
    >```json
    >{
    >    "status": 0,
    >    "data": {
    >        "shop_car_goods_vo_list": [
    >            {
    >                "goods_id": 700017327848030208,
    >                "quantity": 1,
    >                "goods_title": "G-SHOCK 黑金时尚电子手表",
    >                "goods_img": null,
    >                "goods_price": 10.00,
    >                "goods_status": 1,
    >                "goods_total_price": 10.00,
    >                "goods_count": 105,
    >                "selected": false
    >            },
    >            {
    >                "goods_id": 700017327869001728,
    >                "quantity": 5,
    >                "goods_title": "可口可乐500ml",
    >                "goods_img": null,
    >                "goods_price": 10.00,
    >                "goods_status": 1,
    >                "goods_total_price": 50.00,
    >                "goods_count": 100,
    >                "selected": false
    >            }
    >        ],
    >        "select_all": false,
    >        "shop_car_total_price": 0,
    >        "shop_car_total_quantity": 6
    >    }
    >}
    >```

### 3. 购物车内商品数量（非种类数）统计功能

- **GET** /shopCar/goods/sum

    > *request*
    >
    > ```json
    > 无参数
    > ```
    >
    > *response*
    >
    > ```json
    > {
    >     "status": 0,
    >     "data": 6
    > }
    > ```

## 四、 收货地址模块（shipping）

*注：以下功能均需要登录状态*

### 1. 收货地址增删改功能

- **POST** /shippings

    *增加收货地址，request所有字段均不能为空。*

    >*request*
    >
    >```json
    >{
    >    "shipping_name": "JVxie",
    >    "shipping_phone": "18058061873",
    >    "shipping_province": "福建省",
    >    "shipping_city": "漳州市",
    >    "shipping_district": "芗城区",
    >    "shipping_address": "某大学",
    >    "shipping_zip": "363000"
    >}
    >```
    >
    >*response*
    >
    >- success
    >
    >```json
    >{
    >    "status": 0,
    >    "data": {
    >        "shippingId": 707031620267540480
    >    }
    >}
    >```
    >
    >- failed
    >
    >```json
    >{
    >    "status": 9,
    >    "msg": "失败"
    >}
    >```
    >
    >```json
    >{
    >    "status": 11,
    >    "msg": "XXX不能为空"
    >}
    >```

- **DELETE** /shippings/{shippingId}

    *删除收货地址，shippingId不可为空*

    >*request*
    >
    >```json
    >shippingId = 707031620267540480
    >```
    >
    >*response*
    >
    >- success
    >
    >```json
    >{
    >    "status": 0,
    >    "msg": "成功"
    >}
    >```
    >
    >- failed
    >
    >```json
    >{
    >    "status": 9,
    >    "msg": "失败"
    >}
    >```

- **PUT** /shippings/{shippingId}

    *更改收货地址详情，所有字段均不可为空。*

    >*request*
    >
    >```json
    >shippingId = 707031620267540480
    >{
    >    "shipping_name": "JVxie",
    >    "shipping_phone": "18058061873",
    >    "shipping_province": "北京市",
    >    "shipping_city": "北京",
    >    "shipping_district": "五环",
    >    "shipping_address": "某大学",
    >    "shipping_zip": "010000"
    >}
    >```
    >
    >*response*
    >
    >- success
    >
    >```json
    >{
    >    "status": 0,
    >    "msg": "成功"
    >}
    >```
    >
    >- failed
    >
    >```json
    >{
    >    "status": 9,
    >    "msg": "失败"
    >}
    >```
    >
    >```json
    >{
    >    "status": 11,
    >    "msg": "XXX不能为空"
    >}
    >```

### 2. 收货地址列表功能

- **GET** /shippings

    *获取所有收货地址*

    >*request*
    >
    >```json
    >无参数
    >```
    >
    >*response*
    >
    >- success
    >
    >```json
    >{
    >    "status": 0,
    >    "data": {
    >        "total": 3,
    >        "list": [
    >            {
    >                "shipping_id": 707031620267540480,
    >                "shipping_name": "JVxie",
    >                "shipping_phone": "18058061873",
    >                "shipping_province": "北京市",
    >                "shipping_city": "北京",
    >                "shipping_district": "五环",
    >                "shipping_address": "某大学",
    >                "shipping_zip": "010000"
    >            },
    >            {
    >                "shipping_id": 707035390032478208,
    >                "shipping_name": "JVxie",
    >                "shipping_phone": "18058061873",
    >                "shipping_province": "福建省",
    >                "shipping_city": "漳州市",
    >                "shipping_district": "芗城区",
    >                "shipping_address": "某大学",
    >                "shipping_zip": "363000"
    >            },
    >            {
    >                "shipping_id": 707035397452201984,
    >                "shipping_name": "JVxie",
    >                "shipping_phone": "18058061873",
    >                "shipping_province": "福建省",
    >                "shipping_city": "漳州市",
    >                "shipping_district": "芗城区",
    >                "shipping_address": "某大学",
    >                "shipping_zip": "363000"
    >            }
    >        ],
    >        "page_num": 1,
    >        "page_size": 10,
    >        "size": 3,
    >        "start_row": 1,
    >        "end_row": 3,
    >        "pages": 1,
    >        "pre_page": 0,
    >        "next_page": 0,
    >        "is_first_page": true,
    >        "is_last_page": true,
    >        "has_previous_page": false,
    >        "has_next_page": false,
    >        "navigate_pages": 8,
    >        "navigatepage_nums": [
    >            1
    >        ],
    >        "navigate_first_page": 1,
    >        "navigate_last_page": 1
    >    }
    >}
    >```