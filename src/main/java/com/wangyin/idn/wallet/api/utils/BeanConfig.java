package com.wangyin.idn.wallet.api.utils;


import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by hanxiaofei on 2017/1/16.
 */
@Configuration
@EnableTransactionManagement
@PropertySource(value = {"classpath:jdbc.properties"})
@MapperScan("com.wangyin.idn.wallet.api.mapper")
public class BeanConfig {

    @Autowired
    private Environment env;

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(env.getProperty("promotion.jdbc.driverClassName").trim());
        dataSource.setUrl(env.getProperty("promotion.jdbc.url").trim());
        dataSource.setUsername(env.getProperty("promotion.jdbc.username").trim());
        dataSource.setPassword(env.getProperty("promotion.jdbc.password").trim());
        dataSource.setTransactionQueryTimeout(3000);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        return sessionFactory.getObject();
    }
}
