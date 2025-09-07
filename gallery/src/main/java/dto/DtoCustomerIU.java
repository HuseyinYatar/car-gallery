package dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoCustomerIU extends DtoBaseEntity{

	@NotEmpty
	private String tckNo;

	@NotEmpty
	private String birthOfDate;

	@NotNull
	private DtoAddressIU address;
	
	@NotNull
	private DtoAccountIU account;
}
