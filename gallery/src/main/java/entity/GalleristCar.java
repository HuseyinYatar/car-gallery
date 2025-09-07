package entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Table(uniqueConstraints = { 
		@UniqueConstraint(name = "GalleristAndCar", columnNames = {"gallerist_id","car_id"} )})
@Entity
public class GalleristCar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	private Gallerist gallerist;

	@ManyToOne(cascade = CascadeType.ALL)
	private Car car;
}
