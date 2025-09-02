package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

import enums.*;
@Entity
@Getter
@Setter
public class Account {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String accountNo;
	
	private String iban;
	
	private BigDecimal amount;

	@Enumerated(EnumType.STRING)
	private CurrencyType currencyType;
}
