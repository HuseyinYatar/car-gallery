package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CurrencyItems {
	@JsonProperty("Tarih")
	private String issueDate;

	@JsonProperty("TP_DK_USD_A_YTL")
	private String currency;
}
