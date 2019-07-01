package com.study.test01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.test01.mapper.UserMapperTest01;

import lombok.extern.slf4j.Slf4j;

/**
 * UserServiceTest01<br>
 * 作者: 每特教育-余胜军<br>
 * 联系方式:QQ644064779|WWW.itmayiedu.com<br>
 */
@Service
@Slf4j
public class UserServiceTest01 {
    @Autowired
    private UserMapperTest01 userMapperTest01;

    @Transactional
    public int insertUser(String name, Integer age,String email) {
        int insertUserResult = userMapperTest01.insert(name, age,email);
        log.info("######insertUserResult:{}##########", insertUserResult);
        int i = 1 / age;
        // 怎么样验证事务开启成功!~
        return insertUserResult;
    }

}
