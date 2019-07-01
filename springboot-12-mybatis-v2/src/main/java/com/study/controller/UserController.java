package com.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.service.UserService;

/**
 * 
 * @描述: 测试mybatis整合springboot
 * @版权: Copyright (c) 2019 
 * @公司:  
 * @作者: 严磊
 * @版本: 1.0 
 * @创建日期: Jun 19, 2019 
 * @创建时间: 12:02:51 AM
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/insertUser")
	public Integer insertUser(String name, String email) {
		return userService.insertUser(name, email);
	}

}
