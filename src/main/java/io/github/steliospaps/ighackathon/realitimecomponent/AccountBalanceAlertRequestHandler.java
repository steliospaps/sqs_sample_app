package io.github.steliospaps.ighackathon.realitimecomponent;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

import io.github.steliospaps.ighackathon.realitimecomponent.AccountBalanceAlert.AlertStatus;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
@Component
public class AccountBalanceAlertRequestHandler {

	@Autowired
	private QueueMessagingTemplate queueMessagingTemplate;
	
	private String outputQueueName="output-queue";
	
	@SqsListener(value = "input-queue")
	public void handle(AccountBalanceAlertRequest message) {
		log.info("handle {}",message);
        Flux.just(1)//
                       .delaySubscription(Duration.ofSeconds(10))//
                       .map(m -> AccountBalanceAlert.builder()//
                                       .alertPayload(message.getAlertPayload())//
                                       .status(AlertStatus.TRIGGERED)//
                                       .build())//
                       .doOnNext(m -> log.info("sending {}",m))//
                       .subscribe(m -> queueMessagingTemplate.convertAndSend(outputQueueName, m));
	}

}
