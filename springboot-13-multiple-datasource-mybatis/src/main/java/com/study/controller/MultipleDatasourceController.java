package com.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.entity.User;
import com.study.test01.service.UserService1;
import com.study.test02.service.UserService2;

/**
 * 
 * @����: ʹ�÷ְ��ķ�ʽʹ�ö�����Դ
 * @��Ȩ: Copyright (c) 2019 
 * @��˾:  
 * @����: ����
 * @�汾: 1.0 
 * @��������: Jun 17, 2019 
 * @����ʱ��: 3:23:29 PM
 */
@RestController
@RequestMapping("/user")
public class MultipleDatasourceController
{
    
    /**
       @Repository �� @Service �� @Controller ���Ƿֱ��Ӧ�洢��(dao)Bean��ҵ���(service)Bean����չʾ��(���Ʋ�controller)Bean��
       @Component ��һ�������ĸ��������ʾһ����� (Bean) �������������κβ��
     */
    
    @Autowired
    @Qualifier("UserServiceImpl1")
    UserService1 service1;
    
    @Autowired
    @Qualifier("UserServiceImpl2")
    UserService2 service2;
    
    /**
     * 
     * @�����������û���Ϣ
     * @���ߣ�����
     * @ʱ�䣺Jun 17, 2019 4:28:05 PM
     * @param user
     * @return
     */
    @RequestMapping("/save1")
    public String saveUserController1(User user)
    {
        return "save-result: "+ service1.saveUser(user);
    }
    
    
    /**
     * 
     * @�����������û���Ϣ
     * @���ߣ�����
     * @ʱ�䣺Jun 17, 2019 4:28:05 PM
     * @param user
     * @return
     */
    @RequestMapping("/save2")
    public String saveUserController2(User user)
    {
        return "save-result: "+ service2.saveUser(user);
    }
}
