package mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import dto.DtoAddress;
import dto.DtoAddressIU;
import entity.Address;

@Mapper(componentModel = "spring")
public interface AddressMapping {

	@Mapping(target = "id",ignore = true)
	public Address AddressIUtoAdress(DtoAddressIU addressIU);
	
	public DtoAddress AddressIUtoDtoAdress(DtoAddressIU addressIU);
}
