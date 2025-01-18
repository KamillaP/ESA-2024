package com.library.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.library") // Сканирует ваш проект на наличие компонентов
public class HibernateConfig {

    private final Environment environment; // Для получения свойств из application.properties

    public HibernateConfig(Environment environment) {
        this.environment = environment;
    }

    // Настройка DataSource (соединение с базой данных)
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Library");
        dataSource.setUsername("root");
        dataSource.setPassword("password");
        return dataSource;
    }

    // Настройка EntityManagerFactory (сущности JPA)
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan("com.library.model"); // Путь к пакетам с сущностями
        factoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);

        // Дополнительные настройки Hibernate
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.hbm2ddl.auto", "update"); // Автоматическое обновление схемы базы данных
        hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        hibernateProperties.put("hibernate.show_sql", "true"); // Показывать SQL-запросы в логах

        factoryBean.setJpaProperties(hibernateProperties);
        return factoryBean;
    }

    // Настройка PlatformTransactionManager (менеджер транзакций)
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}
