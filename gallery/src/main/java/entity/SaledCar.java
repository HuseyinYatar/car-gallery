package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name = "saled_car",
		uniqueConstraints = {
		@UniqueConstraint(
		columnNames ={"gallerist_id","car_id","customer_id"},
		name = "car_gallerist_customer")
		}
		)

public class SaledCar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Gallerist gallerist;
   	

	@ManyToOne
	private Car car;
	

	@ManyToOne
	private Customer customer;
	
}
