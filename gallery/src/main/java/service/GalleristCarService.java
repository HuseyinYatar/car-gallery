package service;

import org.springframework.stereotype.Service;

import dto.DtoGalleristCar;
import dto.DtoGalleristCarIU;
import entity.GalleristCar;
import mapper.GalleristCarMapping;
import repository.GalleristCarRepository;

@Service
public class GalleristCarService {

	
	private final GalleristCarRepository carRepository;

	private final GalleristCarMapping carMapping;
	public GalleristCarService(GalleristCarRepository carRepository, GalleristCarMapping carMapping) {
		super();
		this.carRepository = carRepository;
		this.carMapping = carMapping;
	}
	
	
	public DtoGalleristCar saveGalleristCar(DtoGalleristCarIU carIU)
	{
		DtoGalleristCar dtoGalleristCar = carMapping.IUToDto(carIU);
		
		GalleristCar galleristCar = carMapping.IUToEntity(carIU);
		
		
		carRepository.save(galleristCar);
		
		return dtoGalleristCar;
		
		
	}
	
	
	
}
