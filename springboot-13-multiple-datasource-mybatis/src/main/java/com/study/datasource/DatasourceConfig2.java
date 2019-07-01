package com.study.datasource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration // ע�ᵽspringboot������
@MapperScan(basePackages = "com.study.test02", sqlSessionFactoryRef = "test2SqlSessionFactory")
public class DatasourceConfig2
{
    /**
     * 
     * @����������test01���ݿ�
     * @���ߣ�����
     * @ʱ�䣺Jun 19, 2019 7:46:47 PM
     * @return
     */
    @Bean(name = "test2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.test2")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 
     * @������sql�Ự����
     * @���ߣ�����
     * @ʱ�䣺Jun 19, 2019 7:46:59 PM
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "test2SqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test2DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //����sql �� mapper �ļ�
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapping/*.xml"));
        return bean.getObject();
    }

    /**
     * 
     * @�������������
     * @���ߣ�����
     * @ʱ�䣺Jun 19, 2019 7:47:14 PM
     * @param dataSource
     * @return
     */
    @Bean(name = "test2TransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("test2DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "test2SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("test2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
