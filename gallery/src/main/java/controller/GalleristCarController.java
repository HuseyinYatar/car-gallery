package controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.DtoGalleristCar;
import dto.DtoGalleristCarIU;
import entity.RestBaseControllerEntity;
import jakarta.validation.Valid;
import service.GalleristCarService;

@RestController
@RequestMapping("/rest")
public class GalleristCarController extends RestBaseController {

	private final GalleristCarService carService;

	public GalleristCarController(GalleristCarService carService) {
		super();
		this.carService = carService;
	}
	
	
	@PostMapping("/save-gallerist-car")
	public RestBaseControllerEntity<DtoGalleristCar> saveGalleristCar(@RequestBody @Valid DtoGalleristCarIU carIU)
	{
		return ok(carService.saveGalleristCar(carIU));
	}
	
}
