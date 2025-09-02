package dto;

import java.util.Set;

import enums.Roles;
import lombok.Data;

@Data
public class DtoCustomUser {
	
	private String username;

	private Set<Roles> roles;
}
