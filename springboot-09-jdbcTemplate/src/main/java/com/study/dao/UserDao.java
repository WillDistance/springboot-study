package com.study.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.study.entity.User;

/**
 * 
 * @����: ���ݿ����dao��
 * @��Ȩ: Copyright (c) 2019 
 * @��˾:  
 * @����: ����
 * @�汾: 1.0 
 * @��������: Jun 17, 2019 
 * @����ʱ��: 3:14:39 PM
 */

@Repository
public class UserDao {
    /**
       @Repository �� @Service �� @Controller ���Ƿֱ��Ӧ�洢��(dao)Bean��ҵ���(service)Bean����չʾ��(���Ʋ�controller)Bean��
       @Component ��һ�������ĸ��������ʾһ����� (Bean) �������������κβ��
     */
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int save(User user) {
        String sql = "insert into t_user(name, email) values(?,?)";
        return jdbcTemplate.update(sql, user.getName(), user.getEmail());
    }
    
    public Map<String, Object> query(int id) {
        String sql = "select * from t_user where id = ?";
        return jdbcTemplate.queryForMap(sql, new Object[] {id});
    }
}