package com.artivisi.training.spring;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:jdbc.properties")
@ComponentScan(basePackages = "com.artivisi.training.spring.dao")
public class KonfigurasiAplikasi {
    
    @Value("${database.url}")
    private String dbUrl;
    @Value("${database.username}")
    private String dbUsername;
    @Value("${database.password}")
    private String dbPassword;
    
    @Bean
    public DataSource ds1(){
        MysqlDataSource c = new MysqlDataSource();
        c.setUrl(dbUrl);
        c.setUser(dbUsername);
        c.setPassword(dbPassword);
        return c;
    }
    
    // supaya ${variabel} dalam jdbc.properties bisa dibaca
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }
}
