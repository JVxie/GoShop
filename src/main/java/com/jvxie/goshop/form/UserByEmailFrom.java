package com.jvxie.goshop.form;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserByEmailFrom extends UserFrom {
    @Email(message = "邮箱地址填写错误")
    @NotBlank(message = "邮箱地址不能为空")
    private String userEmail;
}
