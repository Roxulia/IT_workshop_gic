package com.example.gicws2.demo.Config;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    // Primary DataSource
    @Primary
    @Bean(name = "mainDataSource")
    public DataSource mainDataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:3306/mydb")
                .username("root")
                .password("221072Zlh@")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }

    // Secondary DataSource
    @Bean(name = "secondaryDataSource")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:3306/secondarydb")
                .username("root")
                .password("221072Zlh@")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }
}
