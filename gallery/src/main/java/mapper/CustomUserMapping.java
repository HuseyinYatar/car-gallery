package mapper;

import org.mapstruct.Mapper;

import dto.DtoCustomUser;
import entity.CustomUser;

@Mapper(componentModel = "spring")
public interface CustomUserMapping {

	DtoCustomUser customuserToDtoCustomUser(CustomUser customUser);
}
