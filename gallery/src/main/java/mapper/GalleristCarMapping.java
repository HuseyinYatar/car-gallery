package mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import dto.DtoGalleristCar;
import dto.DtoGalleristCarIU;
import entity.GalleristCar;

@Mapper(componentModel = "spring",uses = {CarMapping.class,GalleristMapping.class })
public interface GalleristCarMapping {

	
	DtoGalleristCar IUToDto(DtoGalleristCarIU carIU);
	
	
	@Mapping(target = "id",ignore = true)
	GalleristCar IUToEntity(DtoGalleristCarIU carIU);
}
