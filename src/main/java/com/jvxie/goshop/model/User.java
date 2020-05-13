package com.jvxie.goshop.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * user
 * @author 
 */
@Data
public class User implements Serializable {
    /**
     * 作主键用
     */
    private Integer id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户名，无用户名默认以用户+ID作
     */
    private String userName;

    /**
     * 用户密码，加密存储
     */
    private String userPsw;

    /**
     * 用户组ID，0：管理员，1：普通用户，2：卖家
     */
    private Integer userGroupId;

    /**
     * 用户性别，1：男，2：女，3：其他
     */
    private Integer userSex;

    /**
     * 用户真实姓名
     */
    private String realName;

    /**
     * 用户手机号码
     */
    private String userPhone;

    /**
     * 用户电子邮箱
     */
    private String userEmail;

    /**
     * 找回密码问题
     */
    private String userQuestion;

    /**
     * 找回密码答案
     */
    private String userAnswer;

    /**
     * 上次登录时间
     */
    private Date lastLoginTime;

    /**
     * 上次登录ip
     */
    private String lastLoginIp;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除时间
     */
    private Date deleteTime;
}