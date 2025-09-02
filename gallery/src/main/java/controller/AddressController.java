package controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.DtoAddress;
import dto.DtoAddressIU;
import entity.RestBaseControllerEntity;
import jakarta.validation.Valid;
import service.AddressService;

@RestController
@RequestMapping("/rest")
public class AddressController extends RestBaseController {

	private final AddressService addressService;

	public AddressController(AddressService addressService) {
		super();
		this.addressService = addressService;
	}

	@PostMapping("/save-address")
	public RestBaseControllerEntity<DtoAddress> saveAddress(@RequestBody @Valid DtoAddressIU addressIU) {
		return ok(addressService.saveAddress(addressIU));
	}
}
