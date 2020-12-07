package io.github.steliospaps.ighackathon.realitimecomponent;

import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AccountBalanceAlertRequestHandler {

	
	@SqsListener(value = "input-queue")
	public void handle(AccountBalanceAlertRequest message) {
		log.info("handle {}",message);
		
	}

}
