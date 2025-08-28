package entity;

import enums.CarStatusType;
import enums.CurrencyType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	private String plaka;

	@Column
	private String model;

	@Column
	private String productionYear;

	@Column
	private String price;

	@Enumerated(EnumType.STRING)
	private CurrencyType currencyType;

	@Column
	private String damagePrice;

	@Enumerated(EnumType.STRING)
	private CarStatusType carStatusType;

}
