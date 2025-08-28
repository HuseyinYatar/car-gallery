package enums;

import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority{

	ADMIN,
	USER;

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return name();
	}
}
