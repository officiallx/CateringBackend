package org.obnoxious;

import org.obnoxious.config.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EntityScan
@EnableConfigurationProperties({ FileStorageProperties.class })
@AutoConfigurationPackage
public class CrudBackendApplication extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(CrudBackendApplication.class, args);
	}
}
