package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @描述: SpringBoot 整合jsp
 * @版权: Copyright (c) 2019 
 * @公司:  
 * @作者: 严磊
 * @版本: 1.0 
 * @创建日期: Jun 15, 2019 
 * @创建时间: 11:03:33 PM
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
