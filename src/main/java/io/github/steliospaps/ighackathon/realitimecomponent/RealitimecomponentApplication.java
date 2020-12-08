package io.github.steliospaps.ighackathon.realitimecomponent;

import static java.util.Collections.singletonList;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.aws.core.env.ResourceIdResolver;
import org.springframework.cloud.aws.messaging.config.QueueMessageHandlerFactory;
import org.springframework.cloud.aws.messaging.config.annotation.EnableSqs;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.handler.annotation.support.PayloadArgumentResolver;
import org.springframework.messaging.handler.annotation.support.PayloadMethodArgumentResolver;
import org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolver;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClient;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@EnableSqs
public class RealitimecomponentApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealitimecomponentApplication.class, args);
	}

	@Bean
	@ConditionalOnProperty("localstack.aws.endpoint")
	@Primary
	public AmazonSQSAsync localstackAmazonSqs(@Value("${localstack.aws.endpoint}") String endpoint,
			AWSCredentialsProvider credentialsProvider) {
		return AmazonSQSAsyncClient.asyncBuilder()//
				.withCredentials(credentialsProvider)//
				.withEndpointConfiguration(new EndpointConfiguration(endpoint, "eu-west-1"))//
				.build();
	}

	
	//see https://stackoverflow.com/questions/50867684/spring-cloud-sqslistener-messageconversionexception-cannot-convert-from-java
	/** Provides a deserialization template for incoming SQS messages */
/*	@SuppressWarnings("deprecation")
	@Bean
	public QueueMessageHandlerFactory queueMessageHandlerFactory(MessageConverter messageConverter) {

	    var factory = new QueueMessageHandlerFactory();
	    factory.setArgumentResolvers(singletonList(new PayloadArgumentResolver(messageConverter)));
	    return factory;
	}
*/

	@Bean
	public QueueMessageHandlerFactory queueMessageHandlerFactory() {
		QueueMessageHandlerFactory factory = new QueueMessageHandlerFactory();
		MappingJackson2MessageConverter messageConverter = new MappingJackson2MessageConverter();

		//set strict content type match to false
		messageConverter.setStrictContentTypeMatch(false);
		factory.setArgumentResolvers(Collections.<HandlerMethodArgumentResolver>singletonList(new PayloadMethodArgumentResolver(messageConverter)));
		return factory;
	}
	
	/** Provides a serialization template for outgoing SQS messages */
/*	@Bean
	public QueueMessagingTemplate queueMessagingTemplate(AmazonSQSAsync amazonSQSAsync, MessageConverter messageConverter) {
	    return new QueueMessagingTemplate(amazonSQSAsync, (ResourceIdResolver) null, messageConverter);
	}
*/
	/** Provides JSON converter for SQS messages */
/*	@Bean
	protected MessageConverter messageConverter(ObjectMapper objectMapper) {

	  var converter = new MappingJackson2MessageConverter();
	  converter.setObjectMapper(objectMapper);
	  // Serialization support:
	  converter.setSerializedPayloadClass(String.class);
	  // Deserialization support: (suppress "contentType=application/json" header requirement)
	  converter.setStrictContentTypeMatch(false);
	  return converter;
	}
*/
}
