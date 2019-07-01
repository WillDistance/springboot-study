package com.study.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.dao.UserDao;
import com.study.entity.User;
import com.study.service.UserService;

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

@Service
public class UserServiceImpl implements UserService
{
    /**
       @Repository �� @Service �� @Controller ���Ƿֱ��Ӧ�洢��(dao)Bean��ҵ���(service)Bean����չʾ��(���Ʋ�controller)Bean��
       @Component ��һ�������ĸ��������ʾһ����� (Bean) �������������κβ��
     */
    
    @Autowired
    UserDao userDao;

    /**
     * 
     * @�������洢�û���Ϣ��ʹ����DatasourceConfig�д���ʱ�����������������
     * @���ߣ�����
     * @ʱ�䣺Jun 17, 2019 3:53:08 PM
     * @param user
     */
    @Override
    @Transactional
    public int saveUser(User user)
    {
        int resultInt = userDao.save(user);
        System.out.println(1/(user.getAge()%2)); //�����׳��쳣
        return resultInt;
    }
    
    /**
     * 
     * @��������ѯ�û���Ϣ
     * @���ߣ�����
     * @ʱ�䣺Jun 17, 2019 3:53:14 PM
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> queryUser(int id)
    {
        return userDao.query(id);
    }
    
}
