package dto;

import lombok.Data;

@Data
public class DtoSoldCarRequest {

	private Long customerId;

	private Long galleristId;

	private Long carId;
}
