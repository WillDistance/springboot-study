package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @����: SpringBoot ����jsp
 * @��Ȩ: Copyright (c) 2019 
 * @��˾:  
 * @����: ����
 * @�汾: 1.0 
 * @��������: Jun 15, 2019 
 * @����ʱ��: 11:03:33 PM
 */

@Controller
@RequestMapping(value="/JspController")
public class JspController
{
    
    @RequestMapping(value="/jspIndex")
    public String jspIndex() {
        return "jspIndex";
        
    }
}
