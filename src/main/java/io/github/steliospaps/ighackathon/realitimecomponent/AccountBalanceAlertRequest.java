package io.github.steliospaps.ighackathon.realitimecomponent;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountBalanceAlertRequest {
	private String accountId;
	private String oauthToken;
	private BigDecimal targetValue;
	private boolean alertWhenBigger=false;
	private String alertPayload;
}
