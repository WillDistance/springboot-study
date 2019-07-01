package com.study.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.entity.User;
import com.study.service.UserPrimaryService;
import com.study.service.UserSecondaryService;

/**
 * 
 * @描述: 控制层
 * @版权: Copyright (c) 2019 
 * @公司:  
 * @作者: 严磊
 * @版本: 1.0 
 * @创建日期: Jun 17, 2019 
 * @创建时间: 3:23:29 PM
 */
@RestController
@RequestMapping("/user")
public class JdbcMultipleController
{
    
    /**
       @Repository 、 @Service 、 @Controller 它们分别对应存储层(dao)Bean，业务层(service)Bean，和展示层(控制层controller)Bean。
       @Component 是一个泛化的概念，仅仅表示一个组件 (Bean) ，可以作用在任何层次
       
              在多数据源的时候，开启事务必须使用 @Transactional(transactionManager = "secondaryTransactionManager") 的
              方式明确限定事务管理器
     */
    
    @Autowired
    @Qualifier("UserPrimaryService")
    UserPrimaryService primaryService;
    
    @Autowired
    @Qualifier("UserSecondaryService")
    UserSecondaryService secondaryService;
    
    /**
     * 
     * @描述：查询用户信息
     * @作者：严磊
     * @时间：Jun 17, 2019 4:27:49 PM
     * @param id
     * @return
     */
    @RequestMapping("/query")
    public Map<String, Object> queryUserController(int id,String dataType)
    {
        Map<String, Object> result = new HashMap<String, Object>();
        if("primary".equals(dataType))
        {
            result = primaryService.queryUser(id);
        }
        if("secondary".equals(dataType))
        {
            result = secondaryService.queryUser(id);
        }
        return result;
    }
    
    /**
     * 
     * @描述：保存用户信息
     * @作者：严磊
     * @时间：Jun 17, 2019 4:28:05 PM
     * @param user
     * @return
     */
    @RequestMapping("/save")
    public String saveUserController(User user,String dataType)
    {
        int result = -1;
        if("primary".equals(dataType))
        {
            result = primaryService.saveUser(user);
        }
        if("secondary".equals(dataType))
        {
            result = secondaryService.saveUser(user);
        }
        
        return "save-result: "+ result;
    }
    
}
