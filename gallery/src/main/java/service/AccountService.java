package service;

import org.springframework.stereotype.Service;

import dto.DtoAccount;
import dto.DtoAccountIU;
import entity.Account;
import mapper.AccountMapping;
import mapper.AccountMappingImpl;
import repository.AccountRepository;

@Service
public class AccountService {

	private final AccountRepository accountRepository;
	
	private final AccountMapping accountMapping;

	public AccountService(AccountRepository accountRepository, AccountMapping accountMapping) {
		super();
		this.accountRepository = accountRepository;
		this.accountMapping = accountMapping;
	}
	
	
	public DtoAccount saveAccount(DtoAccountIU accountIU)
	{
		DtoAccount dtoAccount=accountMapping.dtoAccountIUtoDtoAccount(accountIU);
		Account account=accountMapping.dtoAccountIUtoAccount(accountIU);
		
		
		accountRepository.save(account);
		return dtoAccount;
		
	}
	
	
	
	
}
