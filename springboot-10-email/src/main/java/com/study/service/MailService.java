package com.study.service;

/**
 * 
 * @����: �ʼ�����service��������ӿ�
 * @��Ȩ: Copyright (c) 2019 
 * @��˾:  
 * @����: ����
 * @�汾: 1.0 
 * @��������: Jun 17, 2019 
 * @����ʱ��: 9:10:51 PM
 */
public interface MailService
{
    /**
     * 
     * @������������ͨ�ı��ʼ�
     * @���ߣ�����
     * @ʱ�䣺Jun 17, 2019 11:27:11 PM
     * @param toUser
     * @param subject
     * @param context
     */
    public void sendSimpleMail(String toUser, String subject, String context);
    
    /**
     * 
     * @����������HTML�ʼ�
     * @���ߣ�����
     * @ʱ�䣺Jun 17, 2019 11:26:46 PM
     * @param toUser
     * @param subject
     * @param context
     */
    public void sendMimeMail(String toUser, String subject, String context);
    
    /**
     * 
     * @���������ʹ��������ʼ�
     * @���ߣ�����
     * @ʱ�䣺Jun 17, 2019 11:27:25 PM
     * @param toUser
     * @param subject
     * @param context
     * @param filePath
     */
    public void sendAttachMail(String[] toUser, String subject, String context, String filePath);
    
    /**
     * 
     * @�������������Ĵ�ͼƬ���ʼ�
     * @���ߣ�����
     * @ʱ�䣺Jun 17, 2019 11:27:40 PM
     * @param toUser
     * @param subject
     * @param context
     * @param filePath
     * @param resId
     */
    public void sendInlineMail(String toUser, String subject, String context, String filePath, String resId);
}
