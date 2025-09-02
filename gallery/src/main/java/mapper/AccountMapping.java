package mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import dto.DtoAccount;
import dto.DtoAccountIU;
import entity.Account;

@Mapper(componentModel = "spring")
public interface AccountMapping {

	DtoAccount dtoAccountIUtoDtoAccount(DtoAccountIU accountIU);
	
	@Mapping(target = "id",ignore =true)
	Account dtoAccountIUtoAccount(DtoAccountIU accountIU);
	
}
