package com.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.entity.User;
import com.study.service.UserService;

/**
 * 
 * @����: ���Ʋ�
 * @��Ȩ: Copyright (c) 2019 
 * @��˾:  
 * @����: ����
 * @�汾: 1.0 
 * @��������: Jun 17, 2019 
 * @����ʱ��: 3:23:29 PM
 */
@RestController
@RequestMapping("/user")
public class JdbcController
{
    
    /**
       @Repository �� @Service �� @Controller ���Ƿֱ��Ӧ�洢��(dao)Bean��ҵ���(service)Bean����չʾ��(���Ʋ�controller)Bean��
       @Component ��һ�������ĸ��������ʾһ����� (Bean) �������������κβ��
     */
    
    @Autowired
    UserService service;
    
    /**
     * 
     * @��������ѯ�û���Ϣ
     * @���ߣ�����
     * @ʱ�䣺Jun 17, 2019 4:27:49 PM
     * @param id
     * @return
     */
    @RequestMapping("/query")
    public User queryUserController(int id)
    {
        return service.queryUser(id);
    }
    
    /**
     * 
     * @�����������û���Ϣ
     * @���ߣ�����
     * @ʱ�䣺Jun 17, 2019 4:28:05 PM
     * @param user
     * @return
     */
    @RequestMapping("/save")
    public String saveUserController(User user)
    {
        return "save-result: "+ service.saveUser(user);
    }
    
}
