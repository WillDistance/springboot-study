package com.study.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import java.io.File;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.study.service.MailService;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @描述: 邮件发送service服务层对外接口实现类
 * @版权: Copyright (c) 2019 
 * @公司:  
 * @作者: 严磊
 * @版本: 1.0 
 * @创建日期: Jun 17, 2019 
 * @创建时间: 9:15:25 PM
 */
@Slf4j
@Service
public class MailServiceImpl implements MailService
{
    @Autowired
    private JavaMailSender mailSender;//注入JavaMailSender，具体发送工作需要它完成
    
    @Value("${spring.mail.username}") //从配置文件中获取发件人邮箱
    public String          from;
    
    /**
     * 
     * @描述：发送普通文本邮件
     * @作者：严磊
     * @时间：Jun 17, 2019 9:26:02 PM
     * @param to
     * @param subject
     * @param context
     */
    @Override
    public void sendSimpleMail(String toUser, String subject, String context)
    {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);//发件人
        mailMessage.setTo(toUser);//收件人
        mailMessage.setSubject(subject);//邮件主题
        mailMessage.setText(context);//邮件正文
        mailSender.send(mailMessage);//发送邮件
        
        log.info("邮件发送成功");
    }
    
    /**
     * 
     * @描述：发送HTML邮件
     * @作者：严磊
     * @时间：Jun 17, 2019 9:25:55 PM
     * @param to
     * @param subject
     * @param context
     */
    @Override
    public void sendMimeMail(String toUser, String subject, String context)
    {
        MimeMessage mailMessage = mailSender.createMimeMessage();
        try
        {
            //发送非纯文本的邮件都需要用的helper来解析
            MimeMessageHelper helper = new MimeMessageHelper(mailMessage);
            helper.setFrom(from);
            helper.setTo(toUser);
            //helper.setBcc("xxxx@qq.com");//抄送人
            helper.setSubject(subject);
            helper.setText(context, true);//这里的第二个参数要为true才会解析html内容
            mailSender.send(mailMessage);
            log.info("邮件发送成功");
        }
        catch (Exception ex)
        {
            log.error("邮件发送失败", ex);
        }
    }
    
    /**
     * 
     * @描述：发送带附件的邮件
     * @作者：严磊
     * @时间：Jun 17, 2019 9:25:46 PM
     * @param to
     * @param subject
     * @param context
     * @param filePath
     */
    @Override
    public void sendAttachMail(String[] toUser, String subject, String context, String filePath)
    {
        MimeMessage message = mailSender.createMimeMessage();
        try
        {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(toUser);
            helper.setSubject(subject);
            helper.setText(context);
            
            FileSystemResource file = new FileSystemResource(new File(filePath));
            helper.addAttachment(file.getFilename(), file);//添加附件，需要用到FileStstemResource
            
            mailSender.send(message);
            log.info("带邮件的附件发送成功");
        }
        catch (Exception ex)
        {
            log.error("带附件的邮件发送失败", ex);
        }
    }
    
    /**
     * 
     * @描述：发送正文带图片的邮件
     * @作者：严磊
     * @时间：Jun 17, 2019 9:25:36 PM
     * @param to
     * @param subject
     * @param context
     * @param filePath
     * @param resId
     */
    @Override
    public void sendInlineMail(String toUser, String subject, String context, String filePath, String resId)
    {
        MimeMessage message = mailSender.createMimeMessage();
        try
        {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(toUser);
            helper.setSubject(subject);
            helper.setText(context, true);
            
            FileSystemResource res = new FileSystemResource(new File(filePath));
            helper.addInline(resId, res);
            mailSender.send(message);
            log.info("邮件发送成功");
        }
        catch (Exception ex)
        {
            log.error("邮件发送失败", ex);
        }
    }
}
