package com.study.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
public class User
{
    /**
      lombok ����ײ�ʹ���ֽ��뼼�� ASM���޸��ֽ����ļ�����get��set���� 
     
      @Slf4j �൱�� private static final Logger logger = LoggerFactory.getLogger(Log4jController.class);
      @Getter @Setter  �Զ�����get��set ����
     */
    private String name;
    private int age;
    
   
}
