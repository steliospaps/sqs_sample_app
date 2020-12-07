package io.github.steliospaps.ighackathon.realitimecomponent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.messaging.config.annotation.EnableSqs;
import org.springframework.cloud.aws.messaging.config.annotation.SqsClientConfiguration;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
@EnableSqs
public class RealitimecomponentApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealitimecomponentApplication.class, args);
	}
	
	
}
