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
public class JdbcMultipleController
{
    
    /**
       @Repository �� @Service �� @Controller ���Ƿֱ��Ӧ�洢��(dao)Bean��ҵ���(service)Bean����չʾ��(���Ʋ�controller)Bean��
       @Component ��һ�������ĸ��������ʾһ����� (Bean) �������������κβ��
       
              �ڶ�����Դ��ʱ�򣬿����������ʹ�� @Transactional(transactionManager = "secondaryTransactionManager") ��
              ��ʽ��ȷ�޶����������
     */
    
    @Autowired
    @Qualifier("UserPrimaryService")
    UserPrimaryService primaryService;
    
    @Autowired
    @Qualifier("UserSecondaryService")
    UserSecondaryService secondaryService;
    
    /**
     * 
     * @��������ѯ�û���Ϣ
     * @���ߣ�����
     * @ʱ�䣺Jun 17, 2019 4:27:49 PM
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
     * @�����������û���Ϣ
     * @���ߣ�����
     * @ʱ�䣺Jun 17, 2019 4:28:05 PM
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
