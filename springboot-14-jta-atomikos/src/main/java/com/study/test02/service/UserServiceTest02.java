package com.study.test02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.test01.mapper.UserMapperTest01;
import com.study.test02.mapper.UserMapperTest02;

import lombok.extern.slf4j.Slf4j;

/**
 * UserServiceTest02<br>
 * ����: ÿ�ؽ���-��ʤ��<br>
 * ��ϵ��ʽ:QQ644064779|WWW.itmayiedu.com<br>
 */
@Service
@Slf4j
public class UserServiceTest02 {
    @Autowired
    private UserMapperTest02 userMapperTest02;
    @Autowired
    private UserMapperTest01 userMapperTest01;
    
    @Transactional
    public int insertUser(String name, Integer age,String email) {
        int insertUserResult = userMapperTest02.insert(name, age,email);
        log.info("######insertUserResult:{}##########", insertUserResult);
        // ��ô����֤�������ɹ�!~
        int i = 1 / age;
        return insertUserResult;
    }

    @Transactional
    public int insertUserTest01AndTest02(String name, Integer age,String email) {
        // ��ͳ�ֲ�ʽ���������� jta+atomikos ע��ͬһ��ȫ��������
        // ��һ������Դ
        int insertUserResult01 = userMapperTest01.insert(name, age,email);
        // �ڶ�������Դ
        int insertUserResult02 = userMapperTest02.insert(name, age,email);
        int i = 1 / age;
        int result = insertUserResult01 + insertUserResult02;
        // test01��� test02�ع�
        return result;
    }

}
