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
 * @����: �û���Ϣservice��������ӿ�ʵ����
 * @��Ȩ: Copyright (c) 2019 
 * @��˾:  
 * @����: ����
 * @�汾: 1.0 
 * @��������: Jun 17, 2019 
 * @����ʱ��: 3:16:34 PM
 */

@Service("UserServiceImpl2")
public class UserServiceImpl2 implements UserService2
{
    /**
    @Repository �� @Service �� @Controller ���Ƿֱ��Ӧ�洢��(dao)Bean��ҵ���(service)Bean����չʾ��(���Ʋ�controller)Bean��
    @Component ��һ�������ĸ��������ʾһ����� (Bean) �������������κβ��
    */
    
    @Autowired
    UserMappre1 userMappre;
    
    
    /**
     * 
     * @�������洢�û���Ϣ
     * @���ߣ�����
     * @ʱ�䣺Jun 17, 2019 3:53:08 PM
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
