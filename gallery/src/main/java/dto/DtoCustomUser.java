package dto;

import java.util.Set;

import enums.Roles;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoCustomUser {
	
	private String username;

	private Set<Roles> roles;
}
