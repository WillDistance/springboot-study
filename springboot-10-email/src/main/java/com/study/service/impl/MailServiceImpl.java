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
 * @����: �ʼ�����service��������ӿ�ʵ����
 * @��Ȩ: Copyright (c) 2019 
 * @��˾:  
 * @����: ����
 * @�汾: 1.0 
 * @��������: Jun 17, 2019 
 * @����ʱ��: 9:15:25 PM
 */
@Slf4j
@Service
public class MailServiceImpl implements MailService
{
    @Autowired
    private JavaMailSender mailSender;//ע��JavaMailSender�����巢�͹�����Ҫ�����
    
    @Value("${spring.mail.username}") //�������ļ��л�ȡ����������
    public String          from;
    
    /**
     * 
     * @������������ͨ�ı��ʼ�
     * @���ߣ�����
     * @ʱ�䣺Jun 17, 2019 9:26:02 PM
     * @param to
     * @param subject
     * @param context
     */
    @Override
    public void sendSimpleMail(String toUser, String subject, String context)
    {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);//������
        mailMessage.setTo(toUser);//�ռ���
        mailMessage.setSubject(subject);//�ʼ�����
        mailMessage.setText(context);//�ʼ�����
        mailSender.send(mailMessage);//�����ʼ�
        
        log.info("�ʼ����ͳɹ�");
    }
    
    /**
     * 
     * @����������HTML�ʼ�
     * @���ߣ�����
     * @ʱ�䣺Jun 17, 2019 9:25:55 PM
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
            //���ͷǴ��ı����ʼ�����Ҫ�õ�helper������
            MimeMessageHelper helper = new MimeMessageHelper(mailMessage);
            helper.setFrom(from);
            helper.setTo(toUser);
            //helper.setBcc("xxxx@qq.com");//������
            helper.setSubject(subject);
            helper.setText(context, true);//����ĵڶ�������ҪΪtrue�Ż����html����
            mailSender.send(mailMessage);
            log.info("�ʼ����ͳɹ�");
        }
        catch (Exception ex)
        {
            log.error("�ʼ�����ʧ��", ex);
        }
    }
    
    /**
     * 
     * @���������ʹ��������ʼ�
     * @���ߣ�����
     * @ʱ�䣺Jun 17, 2019 9:25:46 PM
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
            helper.addAttachment(file.getFilename(), file);//��Ӹ�������Ҫ�õ�FileStstemResource
            
            mailSender.send(message);
            log.info("���ʼ��ĸ������ͳɹ�");
        }
        catch (Exception ex)
        {
            log.error("���������ʼ�����ʧ��", ex);
        }
    }
    
    /**
     * 
     * @�������������Ĵ�ͼƬ���ʼ�
     * @���ߣ�����
     * @ʱ�䣺Jun 17, 2019 9:25:36 PM
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
            log.info("�ʼ����ͳɹ�");
        }
        catch (Exception ex)
        {
            log.error("�ʼ�����ʧ��", ex);
        }
    }
}
