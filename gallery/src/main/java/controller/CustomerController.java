package controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.DtoCustomer;
import dto.DtoCustomerIU;
import entity.RestBaseControllerEntity;
import jakarta.validation.Valid;
import service.CustomerService;

@RestController
@RequestMapping("/rest")
public class CustomerController extends RestBaseController{

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@PostMapping("/save-customer")
	public RestBaseControllerEntity<DtoCustomer> saveCustomer(@RequestBody @Valid DtoCustomerIU customerIU) {

		return ok(customerService.saveCustomer(customerIU));
	}

}
