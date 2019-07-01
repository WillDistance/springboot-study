package com.study.member.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @����: springboot ��һ������
 * @��Ȩ: Copyright (c) 2019 
 * @��˾:  
 * @����: ����
 * @�汾: 1.0 
 * @��������: Jun 12, 2019 
 * @����ʱ��: 11:30:06 PM
 */

@RestController
public class MemberController
{
    //@RestControllerע�� ��ʾ���������з�������json��ʽ  ��ͬ��@Controller(��������) + @ResponseBody(���ڷ�����,��������json��ʽ)
    //springboot����ԭ��:springMVCע�ⷽʽ���� ����HTTP��������Ĭ����Tomcat��
    
    @RequestMapping("/memberIndex")
    public String memberIndex() {
        return "springboot 01 ";
    }
    
    
}
