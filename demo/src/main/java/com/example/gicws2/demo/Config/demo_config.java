package com.example.gicws2.demo.Config;


import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class demo_config {


    @Bean
    public DataSource dataSource()
    { return DataSourceBuilder.create()
            //.driverClassName("com.mysql.cj.jdbc.Driver")
            .url("jdbc:mysql://localhost:3306/mydb")
            .username("user")
            .password("password")
            .build();
    }

}
