package com.study.controller;

import java.util.List;
import java.util.Map;

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
public class MybatisController
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
    public List<User> queryUserController(int id,String name)
    {
        return service.queryUser(id,name);
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
