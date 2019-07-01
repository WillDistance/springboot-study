package com.study.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @描述: springboot 整合Freemarker
 * @版权: Copyright (c) 2019 
 * @公司:  
 * @作者: 严磊
 * @版本: 1.0 
 * @创建日期: Jun 13, 2019 
 * @创建时间: 11:49:20 PM
 */
@Controller
@RequestMapping(value = "/controller")
public class FreemarkerController
{
    @RequestMapping("/freemarkerIndex_01")
    public String freemarkerIndex1(Map<String,Object> map){
        map.put("name","小米");
        map.put("study", "springboot");
        return "freemarker_01";
    }
    
    @RequestMapping("/freemarkerIndex_02")
    public String freemarkerIndex2(Map<String,Object> map){
        map.put("name", "二狗儿");
        map.put("sex", "0");
        List<String> listResult = new ArrayList<String>();
        listResult.add("狗蛋儿");
        listResult.add("lisi");
        listResult.add("翠花");
        map.put("listResult", listResult);
        return "freemarker_02";
    }
}
