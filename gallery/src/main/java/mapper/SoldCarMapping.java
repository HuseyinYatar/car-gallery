package mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import dto.DtoSoldCar;
import dto.DtoSoldCarResponse;
import entity.SoldCar;


@Mapper(componentModel = "spring",uses = {CarMapping.class,CustomerMapping.class,GalleristMapping.class})
public interface SoldCarMapping {
	DtoSoldCarResponse dtoToResponse(DtoSoldCar car);
	
	@Mapping(target = "id",ignore = true)
	SoldCar dtoToEntity(DtoSoldCar car);
}
