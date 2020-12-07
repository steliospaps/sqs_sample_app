package io.github.steliospaps.ighackathon.realitimecomponent.dev;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.amazonaws.services.sqs.AmazonSQSAsyncClient;
import com.amazonaws.services.sqs.buffered.AmazonSQSBufferedAsyncClient;

/**
 * hack spring cloud so that we can connect to the local server
 * @author stelios
 *
 */
@Configuration
@ConditionalOnProperty("app.")
public class DevConfig {
/*
	@Bean
	public AmazonSQSBufferedAsyncClient localAmazonSQSBufferedAsyncClient() {
		client = AmazonSQSAsyncClient.asyncBuilder().withEndpointConfiguration();
	}*/
}
