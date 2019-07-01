package com.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.entity.User;
import com.study.service.MailService;
import com.study.service.UserService;

/**
 * 
 * @����: springboot ���� JavaMailSender �����ʼ�
 * @��Ȩ: Copyright (c) 2019 
 * @��˾:  
 * @����: ����
 * @�汾: 1.0 
 * @��������: Jun 17, 2019 
 * @����ʱ��: 11:29:40 PM
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
     * @���������ı��ʼ�
     * @���ߣ�����
     * @ʱ�䣺Jun 18, 2019 12:09:13 AM
     * @param id
     * @return
     */
    @RequestMapping("/simpleEmail")
    public String simpleEmail(String id)
    {
        User userInfo = userService.queryUser(Integer.parseInt(id));
        String toUser = userInfo.getEmail();
        mailService.sendSimpleMail(toUser,"���ı��ʼ�","��ã�����һ������ʼ�");
        return "�����ʼ��ɹ�";
    }
    
    /**
     * 
     * @������HTML�ʼ�
     * @���ߣ�����
     * @ʱ�䣺Jun 18, 2019 12:09:13 AM
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
                "��ã�<br>" +
                "����һ��HTML�ʼ�\n" +
                "</body>\n" +
                "</html>";
        mailService.sendMimeMail(toUser,"HTML�ʼ�",context);
        return "�����ʼ��ɹ�";
    }
    
    /**
     * 
     * @���������ı��ʼ�
     * @���ߣ�����
     * @ʱ�䣺Jun 18, 2019 12:09:13 AM
     * @param id
     * @return
     */
    @RequestMapping("/attachEmail")
    public String attachEmail(String id)
    {
        User userInfo = userService.queryUser(Integer.parseInt(id));
        String toUser = userInfo.getEmail();
        String[] toUsers = {toUser,"sam.ji@foxmail.com"};
        mailService.sendAttachMail(toUsers,"���������ʼ�","��ã�����һ����������ʼ�","G:\\ȫ��ͼƬ\\����ͼƬ\\t01c5db7e1f92a3879c.jpg");
        return "�����ʼ��ɹ�";
    }
    
    /**
     * 
     * @���������ı��ʼ�
     * @���ߣ�����
     * @ʱ�䣺Jun 18, 2019 12:09:13 AM
     * @param id
     * @return
     */
    @RequestMapping("/inlineEmail")
    public String inlineEmail(String id)
    {
        User userInfo = userService.queryUser(Integer.parseInt(id));
        String toUser = userInfo.getEmail();
        String resId = "t01c5db7e1f92a3879c";
        String context = "<html><body>��ã�<br>����һ�����̬��Դ���ʼ�<br><img src=\'cid:"+resId+"\'></body></html>";
        mailService.sendInlineMail(toUser,"����̬ͼƬ���ʼ�",context,"G:\\\\ȫ��ͼƬ\\\\����ͼƬ\\\\t01c5db7e1f92a3879c.jpg",resId);
        return "�����ʼ��ɹ�";
    }
}
