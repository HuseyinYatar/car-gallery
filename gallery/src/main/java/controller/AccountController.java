package controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.DtoAccount;
import dto.DtoAccountIU;
import entity.RestBaseControllerEntity;
import jakarta.validation.Valid;
import service.AccountService;

@RestController
@RequestMapping("/rest")
public class AccountController  extends RestBaseController{

	private final AccountService accountService;

	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}

	@PostMapping("/save-account")
	public RestBaseControllerEntity<DtoAccount> saveAccount(@Valid @RequestBody DtoAccountIU accountIU) {
		return ok(accountService.saveAccount(accountIU));
	}
}
