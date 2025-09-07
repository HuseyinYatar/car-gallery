package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entity.CurrencyResponse;
import entity.RestBaseControllerEntity;
import service.CurrencyService;

@RestController
@RequestMapping("/rest")
public class CurrencyController  extends RestBaseController{

	private final CurrencyService currencyService;

	public CurrencyController(CurrencyService currencyService) {
		super();
		this.currencyService = currencyService;
	}
	
	@GetMapping("/get-currency")
	public RestBaseControllerEntity<CurrencyResponse> getCurrency(@RequestParam String startDate,@RequestParam String endDate,@RequestParam  String type)
	{
	return ok(currencyService.getCurrency(startDate, endDate, type));
	}
	
}

