package com.study.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.dao.UserMappre;
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
    UserMappre userMapper;

    /**
     * 
     * @�������洢�û���Ϣ
     * @���ߣ�����
     * @ʱ�䣺Jun 17, 2019 3:53:08 PM
     * @param user
     */
    @Override
    public int saveUser(User user)
    {
        return userMapper.saveUserInfo(user);
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
    public List<User> queryUser(int id,String name)
    {
        return userMapper.queryUserInfo(id,name);
    }
    
}
