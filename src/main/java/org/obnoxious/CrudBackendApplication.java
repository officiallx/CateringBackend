package org.obnoxious;

import org.obnoxious.config.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@SpringBootTest(properties="spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration")
@SpringBootApplication
@EntityScan
@EnableConfigurationProperties({ FileStorageProperties.class })
@EnableSwagger2
public class CrudBackendApplication extends SpringBootServletInitializer {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CrudBackendApplication.class, args);
	}

}


