package com.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.mapper.UserMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	@Autowired
	private UserMapper userMapper;

	@Transactional
	public int insertUser(String name, String email) {
	    
		int insertUserResult = userMapper.insert(name, email);
		int i = 1 / Integer.parseInt(name);
		log.info("######insertUserResult:{}##########", insertUserResult);
		// 怎么样验证事务开启成功!~
		return insertUserResult;
	}

}
