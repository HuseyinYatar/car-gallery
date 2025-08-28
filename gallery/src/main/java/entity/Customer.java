package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer extends BaseEntity {

	@Column
	private String tckNo;
	
	@Column
	private String birthOfDate;
	
	@OneToOne
	private Address address;
	
	@OneToOne
	private Account account;
	
}
