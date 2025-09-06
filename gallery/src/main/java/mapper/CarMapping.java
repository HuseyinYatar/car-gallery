package mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import dto.DtoCar;
import dto.DtoCarIU;
import entity.Car;

@Mapper(componentModel = "spring")
public interface CarMapping {
	DtoCar IUToDto(DtoCarIU carIU);
	
	@Mapping(target = "id",ignore = true)
	Car dtoIUToEntitiy(DtoCarIU carIU );
}
