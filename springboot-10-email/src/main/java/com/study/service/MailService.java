package com.study.service;

/**
 * 
 * @描述: 邮件发送service服务层对外接口
 * @版权: Copyright (c) 2019 
 * @公司:  
 * @作者: 严磊
 * @版本: 1.0 
 * @创建日期: Jun 17, 2019 
 * @创建时间: 9:10:51 PM
 */
public interface MailService
{
    /**
     * 
     * @描述：发送普通文本邮件
     * @作者：严磊
     * @时间：Jun 17, 2019 11:27:11 PM
     * @param toUser
     * @param subject
     * @param context
     */
    public void sendSimpleMail(String toUser, String subject, String context);
    
    /**
     * 
     * @描述：发送HTML邮件
     * @作者：严磊
     * @时间：Jun 17, 2019 11:26:46 PM
     * @param toUser
     * @param subject
     * @param context
     */
    public void sendMimeMail(String toUser, String subject, String context);
    
    /**
     * 
     * @描述：发送带附件的邮件
     * @作者：严磊
     * @时间：Jun 17, 2019 11:27:25 PM
     * @param toUser
     * @param subject
     * @param context
     * @param filePath
     */
    public void sendAttachMail(String[] toUser, String subject, String context, String filePath);
    
    /**
     * 
     * @描述：发送正文带图片的邮件
     * @作者：严磊
     * @时间：Jun 17, 2019 11:27:40 PM
     * @param toUser
     * @param subject
     * @param context
     * @param filePath
     * @param resId
     */
    public void sendInlineMail(String toUser, String subject, String context, String filePath, String resId);
}
