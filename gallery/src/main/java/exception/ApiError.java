package exception;

import lombok.Data;

@Data

public class ApiError<T> {

	private CustomException<T> customException ;
	
	private Integer status;

	public void setCustomException(CustomException<T> customException) {
		this.customException=customException;
		
	}
}
