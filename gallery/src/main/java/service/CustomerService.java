package service;

import org.springframework.stereotype.Service;

import dto.DtoCustomer;
import dto.DtoCustomerIU;
import entity.Customer;
import mapper.CustomerMapping;
import repository.CustomerRepository;

@Service
public class CustomerService {

	private final CustomerMapping customerMapping;
	
	private final CustomerRepository customerRepository;

	public CustomerService(CustomerMapping customerMapping, CustomerRepository customerRepository) {
		super();
		this.customerMapping = customerMapping;
		this.customerRepository = customerRepository;
	}
	
	
	public DtoCustomer saveCustomer(DtoCustomerIU customerIU)
	{
		DtoCustomer dtoCustomer = customerMapping.dtoCustomerIUtoDtoCustomer(customerIU);
		
		Customer customer = customerMapping.dtoCustomertoCustomer(customerIU);
		
		customerRepository.save(customer);
		
		return dtoCustomer;
	}
	
	
	
}
