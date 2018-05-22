package com.epam.mentoring.module09.config;

import com.epam.mentoring.module09.services.CabsHelloService;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.sql.DriverManager;
import java.sql.SQLException;

// Valuable annotations:
// @Required, @Autowired, @Qualifier, @Value
// @Component, @Repository, @Service, @Controller
// @Resource, @PostConstruct
// @Scope, @Bean, @DependsOn, @Lazy
// @Import, @Import-resource

@Configuration
@ComponentScan(basePackages = {"com.epam.mentoring.module09"},
        excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class) })
@PropertySource(value = {"classpath:jdbc.properties"})
public class RootConfig {

    @Autowired
    private Environment environment;

    @Bean
//    @Primary
    public DataSource dataSource() {

        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        BasicDataSource ds = new BasicDataSource();
//        ds.setDriverClassName("com.mysql.jdbc.Driver");
//        ds.setUrl("jdbc:mysql://localhost:3306/ammcars");
//        ds.setUsername("root");
//        ds.setPassword("root");

        ds.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        ds.setUrl(environment.getRequiredProperty("jdbc.url"));
        ds.setUsername(environment.getRequiredProperty("jdbc.username"));
        ds.setPassword(environment.getRequiredProperty("jdbc.password"));
        return ds;
    }

    @Bean
    public CabsHelloService cabsHelloService() {
        return new CabsHelloService();
    }
}
