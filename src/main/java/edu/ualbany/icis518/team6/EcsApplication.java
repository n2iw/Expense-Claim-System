package edu.ualbany.icis518.team6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import edu.ualbany.icis518.team6.util.StorageProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class EcsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcsApplication.class, args);
	}
}
