package com.mybatis.encrypt.encryptdemo.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @类描述
 * @time 2020/11/23  17:22
 * @author yangxin
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SysUser {
    private Integer id;

    /**
    * 姓名
    */
    private String name;

    /**
    * 0-无效，1-有效
    */
    private Short status;

    /**
    * 密码
    */
    private String password;

    /**
    * 电话
    */
    private String phoneNumer;

    /**
    * 上一次重置密码时间
    */
    private Date lastResetPasswordTime;

    /**
    * 创建时间
    */
    private Date createAt;

    /**
    * 更新时间
    */
    private Date updateAt;

    /**
    * 0-未删除，1-已删除
    */
    private Short deleted;
}