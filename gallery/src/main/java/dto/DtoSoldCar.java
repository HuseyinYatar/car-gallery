package dto;

import entity.Car;
import entity.Customer;
import entity.Gallerist;
import lombok.Data;

@Data
public class DtoSoldCar {

	private Gallerist gallerist;

	private Car car;

	private Customer customer;

}
