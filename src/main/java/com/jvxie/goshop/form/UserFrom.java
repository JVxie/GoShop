package com.jvxie.goshop.form;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class UserFrom {
    @Pattern(regexp = "^[\\u4E00-\\u9FA5A-Za-z0-9_]{0,18}$", message = "用户名只能包含中文、英文、数字和下划线，且长度不可超过18")
    private String userName;

    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z\\W]{6,18}$", message = "密码只能包含数字和可见字符，且长度在6~18之间")
    private String userPsw;

}
