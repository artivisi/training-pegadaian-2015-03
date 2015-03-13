package com.artivisi.training.spring;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:jdbc.properties")
@ComponentScan(basePackages = "com.artivisi.training.spring.dao")
@EnableTransactionManagement
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
    
    @Autowired @Bean
    public SessionFactory sf(DataSource ds){
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(ds);
        builder.scanPackages("com.artivisi.training.spring");
        builder.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        builder.setProperty("hibernate.show_sql", "true");
        builder.setProperty("hibernate.format_sql", "true");
        return builder.buildSessionFactory();
    }
    
    @Autowired @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sf){
        return new HibernateTransactionManager(sf);
    }
    
    // supaya ${variabel} dalam jdbc.properties bisa dibaca
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }
}
