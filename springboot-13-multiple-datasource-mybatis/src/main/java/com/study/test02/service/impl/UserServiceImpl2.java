package com.study.test02.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.entity.User;
import com.study.test01.service.dao.UserMappre1;
import com.study.test02.service.UserService2;

/**
 * 
 * @描述: 用户信息service服务层对外接口实现类
 * @版权: Copyright (c) 2019 
 * @公司:  
 * @作者: 严磊
 * @版本: 1.0 
 * @创建日期: Jun 17, 2019 
 * @创建时间: 3:16:34 PM
 */

@Service("UserServiceImpl2")
public class UserServiceImpl2 implements UserService2
{
    /**
    @Repository 、 @Service 、 @Controller 它们分别对应存储层(dao)Bean，业务层(service)Bean，和展示层(控制层controller)Bean。
    @Component 是一个泛化的概念，仅仅表示一个组件 (Bean) ，可以作用在任何层次
    */
    
    @Autowired
    UserMappre1 userMappre;
    
    
    /**
     * 
     * @描述：存储用户信息
     * @作者：严磊
     * @时间：Jun 17, 2019 3:53:08 PM
     * @param user
     */
    @Override
    @Transactional(transactionManager = "test2TransactionManager")
    public int saveUser(User user)
    {
        int reusltInt = userMappre.saveUserInfo(user);
        System.out.println(1/(user.getAge()%2));
        return reusltInt;
    }
}
