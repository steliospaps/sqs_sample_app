package io.github.steliospaps.ighackathon.realitimecomponent;

import io.github.steliospaps.ighackathon.realitimecomponent.AccountBalanceAlert.AlertStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountBalanceAlert {
	private String alertPayload;
	private AlertStatus status;
	public enum AlertStatus {
		ERROR,TRIGGERED
	}
}
