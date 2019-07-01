package com.study.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.study.entity.User;

/**
 * 
 * @描述: 数据库访问dao层
 * @版权: Copyright (c) 2019 
 * @公司:  
 * @作者: 严磊
 * @版本: 1.0 
 * @创建日期: Jun 17, 2019 
 * @创建时间: 3:14:39 PM
 */

@Repository
public class UserDao {
    /**
       @Repository 、 @Service 、 @Controller 它们分别对应存储层(dao)Bean，业务层(service)Bean，和展示层(控制层controller)Bean。
       @Component 是一个泛化的概念，仅仅表示一个组件 (Bean) ，可以作用在任何层次
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