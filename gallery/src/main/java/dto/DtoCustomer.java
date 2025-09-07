package dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;



@Setter
@Getter
public class DtoCustomer extends DtoBaseEntity{
	
	@NotNull
	private DtoAddress address;

	@NotNull
	private DtoAccount account;
}
