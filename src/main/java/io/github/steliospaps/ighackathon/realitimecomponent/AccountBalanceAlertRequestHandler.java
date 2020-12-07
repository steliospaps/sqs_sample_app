package io.github.steliospaps.ighackathon.realitimecomponent;

import org.springframework.stereotype.Component;

import io.reflectoring.sqs.api.SqsMessageHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AccountBalanceAlertRequestHandler implements SqsMessageHandler<AccountBalanceAlertRequest> {

	@Override
	public void handle(AccountBalanceAlertRequest message) {
		log.info("handle {}",message);
		
	}

	@Override
	public Class<AccountBalanceAlertRequest> messageType() {
		return AccountBalanceAlertRequest.class;
	}

}
