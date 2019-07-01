package com.study.service;

import java.util.Map;

import com.study.entity.User;

/**
 * 
 * @����:������Դ �û���Ϣservice��������ӿ�
 * @��Ȩ: Copyright (c) 2019 
 * @��˾:  
 * @����: ����
 * @�汾: 1.0 
 * @��������: Jun 17, 2019 
 * @����ʱ��: 3:16:54 PM
 */
public interface UserSecondaryService
{
    /**
     * 
     * @�������洢�û���Ϣ
     * @���ߣ�����
     * @ʱ�䣺Jun 17, 2019 3:53:08 PM
     * @param user
     */
    public int saveUser(User user);
    
    
    /**
     * 
     * @��������ѯ�û���Ϣ
     * @���ߣ�����
     * @ʱ�䣺Jun 17, 2019 3:53:14 PM
     * @param id
     * @return
     */
    public Map<String,Object> queryUser(int id);
    
}
