package io.github.steliospaps.ighackathon.realitimecomponent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;

@SpringBootApplication
public class RealitimecomponentApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealitimecomponentApplication.class, args);
	}
	
	
	@Bean
	public AmazonSQS localAmazonSqs() {
		return AmazonSQSClient.builder()
				.withEndpointConfiguration(new EndpointConfiguration("http://localhost:9324", "http://localhost:9324"))
				.build();
	}
}
