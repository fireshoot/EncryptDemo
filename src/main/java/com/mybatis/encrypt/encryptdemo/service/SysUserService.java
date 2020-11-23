package com.mybatis.encrypt.encryptdemo.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.mybatis.encrypt.encryptdemo.model.SysUser;
import com.mybatis.encrypt.encryptdemo.dao.SysUserMapper;
/**
 * @类描述
 * @time 2020/11/23  17:22
 * @author yangxin
 */
@Service
public class SysUserService{

    @Resource
    private SysUserMapper sysUserMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return sysUserMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(SysUser record) {
        return sysUserMapper.insert(record);
    }

    
    public int insertSelective(SysUser record) {
        return sysUserMapper.insertSelective(record);
    }

    
    public SysUser selectByPrimaryKey(Integer id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(SysUser record) {
        return sysUserMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(SysUser record) {
        return sysUserMapper.updateByPrimaryKey(record);
    }

}
