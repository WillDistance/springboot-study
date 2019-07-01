package com.study.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.study.entity.User;

public interface UserMappre
{
    /**
              让mapper类被spring容器管理的两种方法：  
              1： @Mapper 在Mapper类上面添加注解 @Mapper，这种方式要求每一个mapper类都需要添加此注解
              2： @MapperScan 在启动类加上@MapperScan，可以指定要扫描的Mapper类的包的路径
              多个包： @MapperScan({"com.study.mapper1.*","com.study.mapper2.*"})、@MapperScan({"com.study.*.mapper","com.study.*.mapper"}) 
              单个包： @MapperScan("com.kfit.mapper")   
              
               
               
       dao层需要传入多个参数,我直接传入多个字符串而没有使用map,于是出现了Parameter 'phone' not found. Available parameters are [0, 1, param1, param2]错误
               解决方式：
               1：将多个参数放入map集合中
               2：修改sql为这种模式 select * from u_user where phone=#{0} and loginPassword=#{1}
               3：在dao层方法中加入@Param注释,使value值与sql语句中参数值相同
     */
    
    public int saveUserInfo(User user);
    
    public List<User> queryUserInfo(@Param(value = "id")Integer id,@Param(value = "name") String name);

}
