package controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.DtoSoldCarRequest;
import dto.DtoSoldCarResponse;
import entity.RestBaseControllerEntity;
import service.SoldCarService;

@RestController
@RequestMapping("/rest")
public class SoldCarController extends RestBaseController {

	private final SoldCarService carService;

	public SoldCarController(SoldCarService carService) {
		super();
		this.carService = carService;
	}

	@PostMapping("sell-car")
	public RestBaseControllerEntity<DtoSoldCarResponse> soldCarResponse(@RequestBody DtoSoldCarRequest carRequest) {
		return ok(carService.sellCar(carRequest));
	}
}
