package entity;

import java.math.BigDecimal;

import enums.CarStatusType;
import enums.CurrencyType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	@NotBlank
	private String plaka;

	@NotBlank
	@Column
	private String model;

	@NotBlank
	@Column
	private String productionYear;

	@Column
	private BigDecimal price;
	
	@Enumerated(EnumType.STRING)
	private CurrencyType currencyType;

	@NotBlank
	@Column
	private String damagePrice;
	
	@Enumerated(EnumType.STRING)
	private CarStatusType carStatusType;

	
}
