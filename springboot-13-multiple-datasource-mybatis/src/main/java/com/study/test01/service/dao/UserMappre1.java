package com.study.test01.service.dao;

import com.study.entity.User;

public interface UserMappre1
{
    /**
              ��mapper�౻spring������������ַ�����  
              1�� @Mapper ��Mapper���������ע�� @Mapper�����ַ�ʽҪ��ÿһ��mapper�඼��Ҫ��Ӵ�ע��
              2�� @MapperScan �����������@MapperScan������ָ��Ҫɨ���Mapper��İ���·��
              ������� @MapperScan({"com.study.mapper1.*","com.study.mapper2.*"})��@MapperScan({"com.study.*.mapper","com.study.*.mapper"}) 
              �������� @MapperScan("com.kfit.mapper")   
              
               
               
       dao����Ҫ����������,��ֱ�Ӵ������ַ�����û��ʹ��map,���ǳ�����Parameter 'phone' not found. Available parameters are [0, 1, param1, param2]����
               �����ʽ��
               1���������������map������
               2���޸�sqlΪ����ģʽ select * from u_user where phone=#{0} and loginPassword=#{1}
               3����dao�㷽���м���@Paramע��,ʹvalueֵ��sql����в���ֵ��ͬ
     */
    
    public int saveUserInfo(User user);

}
