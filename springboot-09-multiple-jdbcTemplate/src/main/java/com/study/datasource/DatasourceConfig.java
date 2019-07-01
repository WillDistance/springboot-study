package com.study.datasource;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * 
 * @����: ��ȡ���ݿ������ļ�������jdbcTemplate ��bean����
 * @��Ȩ: Copyright (c) 2019 
 * @��˾:  
 * @����: ����
 * @�汾: 1.0 
 * @��������: Jun 19, 2019 
 * @����ʱ��: 11:58:06 PM
 */
@Configuration
public class DatasourceConfig
{
    /**
     @Bean ��һ�����������ϵ�ע�⣬��Ҫ����@Configurationע������Ҳ��������@Componentע��������ӵ�bean��idΪ������
         Ĭ�������bean�����ƺͷ���������ͬ����Ҳ����ʹ��name������ָ��
         
     @Resource װ��˳��
    ����1. ���ͬʱָ����name��type�����Spring���������ҵ�Ψһƥ���bean����װ�䣬�Ҳ������׳��쳣
    ����2. ���ָ����name������������в������ƣ�id��ƥ���bean����װ�䣬�Ҳ������׳��쳣
    ����3. ���ָ����type��������������ҵ�����ƥ���Ψһbean����װ�䣬�Ҳ��������ҵ�����������׳��쳣
    ����4. �����û��ָ��name����û��ָ��type�����Զ�����byName��ʽ����װ�䣻���û��ƥ�䣬�����Ϊһ��ԭʼ���ͽ���ƥ�䣬���ƥ�����Զ�װ�䣻
     
     @Autowired ��@Resource������
            1�� @Autowired��@Resource����������װ��bean. ������д���ֶ���,��д��setter�����ϡ�
            2�� @AutowiredĬ�ϰ�����װ�䣨���ע������ҵspring�ģ���Ĭ������±���Ҫ���������������ڣ����Ҫ����nullֵ��������������required����Ϊfalse���磺@Autowired(required=false) 
            3�� @Resource�����ע������J2EE�ģ���Ĭ�ϰ������ƽ���װ�䣬���ƿ���ͨ��name���Խ���ָ�������û��ָ��name���ԣ���ע��д���ֶ���ʱ��Ĭ��ȡ�ֶ������а�װ���Ʋ��ң����ע��д��setter������Ĭ��ȡ����������װ�䡣���Ҳ���������ƥ���beanʱ�Ű������ͽ���װ�䡣������Ҫע����ǣ����name����һ��ָ������ֻ�ᰴ�����ƽ���װ��
     
     @Qualifier ��� @Autowired ��������������ͬ��bean��ע������
     
     
           ��ʹ�ö�����Դʱ�����ݿ�url������Ҫ��url�ĳ�jdbc-url ����jdbcUrl is required with driverClassName. ����
     */
    
    
    @Bean(name = "primaryDataSource")
    @Qualifier("primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primaryDataSource()
    {
        return DataSourceBuilder.create().build();
    }
    
    @Bean(name = "secondaryDataSource")
    @Qualifier("secondaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource secondaryDataSource()
    {
        return DataSourceBuilder.create().build();
    }
    
    @Bean(name = "primaryJdbcTemplate")
    public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource") DataSource dataSource)
    {
        return new JdbcTemplate(dataSource);
    }
    
    @Bean(name = "secondaryJdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondaryDataSource") DataSource dataSource)
    {
        return new JdbcTemplate(dataSource);
    }
    
    /**
     * 
     * @������������Ӧ����Դ�����������bean
     * @���ߣ�����
     * @ʱ�䣺Jun 19, 2019 7:47:14 PM
     * @param dataSource
     * @return
     */
    @Bean(name = "primaryTransactionManager")
    public DataSourceTransactionManager primaryTransactionManager(@Qualifier("primaryDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    
    @Bean(name = "secondaryTransactionManager")
    public DataSourceTransactionManager secondaryTransactionManager(@Qualifier("secondaryDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
