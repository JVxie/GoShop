package com.jvxie.goshop.form;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import static com.jvxie.goshop.constants.GoShopConstants.PHONE_REGEXP;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserByPhoneForm extends UserFrom {
    @Pattern(regexp = PHONE_REGEXP, message = "手机号输入错误")
    @NotBlank(message = "手机号不能为空")
    private String userPhone;
}
