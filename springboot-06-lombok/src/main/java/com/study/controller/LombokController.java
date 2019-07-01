package com.study.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.study.entity.User;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @����: lombok ���ʹ��
 * @��Ȩ: Copyright (c) 2019 
 * @��˾:  
 * @����: ����
 * @�汾: 1.0 
 * @��������: Jun 16, 2019 
 * @����ʱ��: 4:46:48 PM
 */
@Slf4j
@RestController
@RequestMapping("/LombokController")
public class LombokController
{
    @RequestMapping("/lombokIndex")
    public String lombokIndex(String name,int age) {
        log.info("ʹ��Lombok����򻯴���");
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return "ʹ��Lombok����򻯴��룺"+user.toString();
    }
}
