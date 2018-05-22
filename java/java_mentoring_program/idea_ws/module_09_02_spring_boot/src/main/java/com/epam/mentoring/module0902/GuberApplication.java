package com.epam.mentoring.module0902;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

// @SpringBootApplication = @Configuration + @ComponentScan + @EnableAutoConfiguration
@SpringBootApplication
public class GuberApplication {

    private static final Logger logger = LoggerFactory.getLogger(GuberApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(GuberApplication.class, args);

        // Spring Boot Actuator - Endpoints and metrics (put the name in browser, for example, localhost:8888/health)
        // health
        // info
        // beans
        // configprops
        // dump
        // env
        // heapdump
        // etc.
    }

    @Bean
    public CommandLineRunner getCommandLineRunner(ApplicationContext ctx) {
        return args -> {
            logger.info("Beans from Spring Boot:");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Stream.of(beanNames)
                    .filter(s -> s.contains("org.springframework.boot"))
                    .sorted()
                    .forEach(logger::info);
        };
    }
}
