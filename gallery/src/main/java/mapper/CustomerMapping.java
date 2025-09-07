package mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import dto.DtoCustomer;
import dto.DtoCustomerIU;
import entity.Customer;

@Mapper(componentModel = "spring",uses = {AddressMapping.class,AccountMapping.class,BaseEntityMapper.class})
public interface CustomerMapping  {

	

	DtoCustomer dtoCustomerIUtoDtoCustomer(DtoCustomerIU dtoCustomerIU);
	
	@Mapping(target = "id",ignore = true)
	Customer dtoCustomertoCustomer(DtoCustomerIU customer);
}
