package com.byoskill.training.junit.realapp.junitrealapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
		org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class}
)
@EnableWebMvc
@EnableJpaRepositories(basePackageClasses = JUnitRealAppApplication.class)
@EntityScan(basePackageClasses = JUnitRealAppApplication.class)
@EnableScheduling
public class JUnitRealAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(JUnitRealAppApplication.class, args);
	}

}
