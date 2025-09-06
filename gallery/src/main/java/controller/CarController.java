package controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.DtoCar;
import dto.DtoCarIU;
import entity.RestBaseControllerEntity;
import jakarta.validation.Valid;
import service.CarService;

@RestController
@RequestMapping("/rest")
public class CarController extends RestBaseController {

	
	private final CarService carService;

	public CarController(CarService carService) {
		super();
		this.carService = carService;
	}
	
	@PostMapping("/save-car")
	public RestBaseControllerEntity<DtoCar> saveCar(@RequestBody @Valid DtoCarIU carIU)
	{
		return ok(carService.saveCar(carIU));
	}
}
