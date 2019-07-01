package com.study.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.dao.UserPrimaryDao;
import com.study.entity.User;
import com.study.service.UserPrimaryService;

/**
 * 
 * @描述: 主数据源 用户信息service服务层对外接口实现类
 * @版权: Copyright (c) 2019 
 * @公司:  
 * @作者: 严磊
 * @版本: 1.0 
 * @创建日期: Jun 17, 2019 
 * @创建时间: 3:16:34 PM
 */

@Service("UserPrimaryService")
public class UserPrimaryServiceImpl implements UserPrimaryService
{
    /**
       @Repository 、 @Service 、 @Controller 它们分别对应存储层(dao)Bean，业务层(service)Bean，和展示层(控制层controller)Bean。
       @Component 是一个泛化的概念，仅仅表示一个组件 (Bean) ，可以作用在任何层次
     */
    
    @Autowired
    UserPrimaryDao userDao;

    /**
     * 
     * @描述：存储用户信息
     * @作者：严磊
     * @时间：Jun 17, 2019 3:53:08 PM
     * @param user
     */
    @Override
    @Transactional(transactionManager = "primaryTransactionManager")
    public int saveUser(User user)
    {
        int resutlInt = userDao.save(user);
        System.out.println(resutlInt/(user.getAge()%3)); //主动触发异常
        return resutlInt;
    }
    
    /**
     * 
     * @描述：查询用户信息
     * @作者：严磊
     * @时间：Jun 17, 2019 3:53:14 PM
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> queryUser(int id)
    {
        return userDao.query(id);
    }
    
}
