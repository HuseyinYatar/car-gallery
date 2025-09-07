package mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import dto.DtoGallerist;
import dto.DtoGalleristIU;
import entity.Gallerist;

@Mapper(componentModel = "spring", uses = {AddressMapping.class,BaseEntityMapper.class})
public interface GalleristMapping {


	@Mapping(target = "id",ignore = true)
	@Mapping(target = "address", source = "address")
	Gallerist DtoIUToEntity(DtoGalleristIU dtoGalleristIU);

	@Mapping(target = "dtoAddress", source = "address")
	DtoGallerist entityToDto(Gallerist gallerist);
	
	@Mapping(target = "dtoAddress", source = "address")
	DtoGallerist IUtoDto(DtoGalleristIU dtoGalleristIU);
	
	
}
