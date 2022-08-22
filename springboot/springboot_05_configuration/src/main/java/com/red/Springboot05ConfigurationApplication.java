package com.red;

import com.alibaba.druid.pool.DruidDataSource;
import com.red.server.ServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
@EnableConfigurationProperties({ServerConfig.class})
public class Springboot05ConfigurationApplication {

    @Bean
    @ConfigurationProperties(prefix = "data-source")
    public DruidDataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Springboot05ConfigurationApplication.class, args);
        ServerConfig serverConfig = context.getBean(ServerConfig.class);
        System.out.println(serverConfig);
        DruidDataSource dataSource = context.getBean(DruidDataSource.class);
        System.out.println(dataSource.getDriverClassName());

    }

}
