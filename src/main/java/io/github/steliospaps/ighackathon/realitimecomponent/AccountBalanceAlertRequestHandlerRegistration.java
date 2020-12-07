package io.github.steliospaps.ighackathon.realitimecomponent;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.amazonaws.services.sqs.AmazonSQS;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.reflectoring.sqs.api.SqsMessageHandler;
import io.reflectoring.sqs.api.SqsMessageHandlerProperties;
import io.reflectoring.sqs.api.SqsMessageHandlerRegistration;
import io.reflectoring.sqs.api.SqsMessagePollerProperties;

@Component
public class AccountBalanceAlertRequestHandlerRegistration implements SqsMessageHandlerRegistration<AccountBalanceAlertRequest> {

  private final AmazonSQS client;
  private final ObjectMapper objectMapper;
  private final AccountBalanceAlertRequestHandler messageHandler;

  @Value("${app.sqs.input-queue.url}")
  private String queueUrl;
  
  public AccountBalanceAlertRequestHandlerRegistration(
      AmazonSQS client, 
      ObjectMapper objectMapper, 
      AccountBalanceAlertRequestHandler messageHandler) {
    this.client = client;
    this.objectMapper = objectMapper;
    this.messageHandler = messageHandler;
  }

  @Override
  public SqsMessageHandler<AccountBalanceAlertRequest> messageHandler() {
    return this.messageHandler;
  }

  @Override
  public String name() {
    return "AccountBalanceAlertRequestHandler";
  }

  @Override
  public SqsMessageHandlerProperties messageHandlerProperties() {
    return new SqsMessageHandlerProperties();
  }

  @Override
  public SqsMessagePollerProperties messagePollerProperties() {
    return new SqsMessagePollerProperties(queueUrl);
  }

  @Override
  public AmazonSQS sqsClient() {
    return this.client;
  }

  @Override
  public ObjectMapper objectMapper() {
    return this.objectMapper;
  }
}