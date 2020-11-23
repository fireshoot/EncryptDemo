package com.mybatis.encrypt.encryptdemo.controller;

import com.mybatis.encrypt.encryptdemo.model.SysUser;
import com.mybatis.encrypt.encryptdemo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangxin
 * @类描述
 * @time 2020/11/23  17:23
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("info")
    public SysUser info(Integer id) {
        return sysUserService.selectByPrimaryKey(id);
    }

    @PostMapping("add")
    public Integer add(@RequestBody SysUser record) {
        sysUserService.insertSelective(record);
        return record.getId();
    }

}
