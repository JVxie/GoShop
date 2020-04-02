package com.jvxie.goshop.form;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserByPhoneForm extends UserFrom {
    @Pattern(regexp = "^(13[0-9]|14[5|7]|15[0-9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$", message = "手机号输入错误")
    @NotBlank(message = "手机号不能为空")
    private String userPhone;
}
