package com.mybatis.encrypt.encryptdemo.dao;

import com.mybatis.encrypt.encryptdemo.model.SysUser;

/**
 * @类描述
 * @time 2020/11/23  17:22
 * @author yangxin
 */
public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}