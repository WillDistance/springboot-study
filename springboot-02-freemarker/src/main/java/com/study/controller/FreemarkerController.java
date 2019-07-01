package com.study.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @����: springboot ����Freemarker
 * @��Ȩ: Copyright (c) 2019 
 * @��˾:  
 * @����: ����
 * @�汾: 1.0 
 * @��������: Jun 13, 2019 
 * @����ʱ��: 11:49:20 PM
 */
@Controller
@RequestMapping(value = "/controller")
public class FreemarkerController
{
    @RequestMapping("/freemarkerIndex_01")
    public String freemarkerIndex1(Map<String,Object> map){
        map.put("name","С��");
        map.put("study", "springboot");
        return "freemarker_01";
    }
    
    @RequestMapping("/freemarkerIndex_02")
    public String freemarkerIndex2(Map<String,Object> map){
        map.put("name", "������");
        map.put("sex", "0");
        List<String> listResult = new ArrayList<String>();
        listResult.add("������");
        listResult.add("lisi");
        listResult.add("�仨");
        map.put("listResult", listResult);
        return "freemarker_02";
    }
}
