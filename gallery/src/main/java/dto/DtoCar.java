package dto;

import java.math.BigDecimal;

import enums.CarStatusType;
import enums.CurrencyType;
import lombok.Data;

@Data
public class DtoCar {
	
	private String plaka;

	private String model;

	private String productionYear;

	private BigDecimal price;

	private CurrencyType currencyType;

	private CarStatusType carStatusType;
}
