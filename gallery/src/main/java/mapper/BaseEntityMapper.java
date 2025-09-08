package mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import dto.DtoBaseEntity;
import entity.BaseEntity;

@Mapper(componentModel = "spring")
public interface BaseEntityMapper {

	@Mapping(target = "id",ignore = true)
	BaseEntity dtoToEntity(DtoBaseEntity baseEntity);
	
	DtoBaseEntity entityToDto(BaseEntity baseEntity );
}
