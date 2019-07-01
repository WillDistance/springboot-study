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
      lombok 插件底层使用字节码技术 ASM，修改字节码文件生成get和set方法 
     
      @Slf4j 相当于 private static final Logger logger = LoggerFactory.getLogger(Log4jController.class);
      @Getter @Setter  自动生成get和set 方法
     */
    private String name;
    private int age;
    
   
}
