package dto;

import java.math.BigDecimal;

import enums.CarStatusType;
import enums.CurrencyType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DtoCarIU {

	private String plaka;

	private String model;

	private String productionYear;

	private BigDecimal price;

	private CurrencyType currencyType;

	private String damagePrice;

	private CarStatusType carStatusType;
}
