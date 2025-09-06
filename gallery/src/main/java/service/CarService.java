package service;

import org.springframework.stereotype.Service;

import dto.DtoCar;
import dto.DtoCarIU;
import entity.Car;
import mapper.CarMapping;
import repository.CarRepository;

@Service
public class CarService {

	private final CarRepository carRepository;

	private final CarMapping carMapping;

	public CarService(CarRepository carRepository, CarMapping carMapping) {
		super();
		this.carRepository = carRepository;
		this.carMapping = carMapping;
	}

	public DtoCar saveCar(DtoCarIU carIU) {
		Car car = carMapping.dtoIUToEntitiy(carIU);
		DtoCar dtoCar = carMapping.IUToDto(carIU);

		carRepository.save(car);

		return dtoCar;
	}
}
