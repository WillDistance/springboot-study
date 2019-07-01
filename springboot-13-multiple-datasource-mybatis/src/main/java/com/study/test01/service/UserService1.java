package com.study.test01.service;

import java.util.List;
import java.util.Map;

import com.study.entity.User;

/**
 * 
 * @描述: 用户信息service服务层对外接口
 * @版权: Copyright (c) 2019 
 * @公司:  
 * @作者: 严磊
 * @版本: 1.0 
 * @创建日期: Jun 17, 2019 
 * @创建时间: 3:16:54 PM
 */
public interface UserService1
{
    /**
     * 
     * @描述：存储用户信息
     * @作者：严磊
     * @时间：Jun 17, 2019 3:53:08 PM
     * @param user
     */
    public int saveUser(User user);
    
}
