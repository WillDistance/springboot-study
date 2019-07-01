package com.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.entity.User;
import com.study.service.MailService;
import com.study.service.UserService;

/**
 * 
 * @描述: springboot 整合 JavaMailSender 发送邮件
 * @版权: Copyright (c) 2019 
 * @公司:  
 * @作者: 严磊
 * @版本: 1.0 
 * @创建日期: Jun 17, 2019 
 * @创建时间: 11:29:40 PM
 */
@RestController
@RequestMapping("/EmailController")
public class EmailController
{
    @Autowired
    MailService mailService;
    
    @Autowired
    UserService userService;
    
    /**
     * 
     * @描述：纯文本邮件
     * @作者：严磊
     * @时间：Jun 18, 2019 12:09:13 AM
     * @param id
     * @return
     */
    @RequestMapping("/simpleEmail")
    public String simpleEmail(String id)
    {
        User userInfo = userService.queryUser(Integer.parseInt(id));
        String toUser = userInfo.getEmail();
        mailService.sendSimpleMail(toUser,"纯文本邮件","你好，这是一封测试邮件");
        return "发送邮件成功";
    }
    
    /**
     * 
     * @描述：HTML邮件
     * @作者：严磊
     * @时间：Jun 18, 2019 12:09:13 AM
     * @param id
     * @return
     */
    @RequestMapping("/mimeEmail")
    public String mimeEmail(String id)
    {
        User userInfo = userService.queryUser(Integer.parseInt(id));
        String toUser = userInfo.getEmail();
        String context = "<html>\n" +
                "<body>\n" +
                "你好，<br>" +
                "这是一封HTML邮件\n" +
                "</body>\n" +
                "</html>";
        mailService.sendMimeMail(toUser,"HTML邮件",context);
        return "发送邮件成功";
    }
    
    /**
     * 
     * @描述：纯文本邮件
     * @作者：严磊
     * @时间：Jun 18, 2019 12:09:13 AM
     * @param id
     * @return
     */
    @RequestMapping("/attachEmail")
    public String attachEmail(String id)
    {
        User userInfo = userService.queryUser(Integer.parseInt(id));
        String toUser = userInfo.getEmail();
        String[] toUsers = {toUser,"sam.ji@foxmail.com"};
        mailService.sendAttachMail(toUsers,"带附件的邮件","你好，这是一封带附件的邮件","G:\\全部图片\\电脑图片\\t01c5db7e1f92a3879c.jpg");
        return "发送邮件成功";
    }
    
    /**
     * 
     * @描述：纯文本邮件
     * @作者：严磊
     * @时间：Jun 18, 2019 12:09:13 AM
     * @param id
     * @return
     */
    @RequestMapping("/inlineEmail")
    public String inlineEmail(String id)
    {
        User userInfo = userService.queryUser(Integer.parseInt(id));
        String toUser = userInfo.getEmail();
        String resId = "t01c5db7e1f92a3879c";
        String context = "<html><body>你好，<br>这是一封带静态资源的邮件<br><img src=\'cid:"+resId+"\'></body></html>";
        mailService.sendInlineMail(toUser,"带静态图片的邮件",context,"G:\\\\全部图片\\\\电脑图片\\\\t01c5db7e1f92a3879c.jpg",resId);
        return "发送邮件成功";
    }
}
