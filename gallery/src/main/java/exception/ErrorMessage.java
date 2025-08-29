package exception;

import enums.ErrorType;
import lombok.Data;

@Data
public class ErrorMessage {

	private String ofStatic;

	private ErrorType errorType;

	public String getErrorMessage(ErrorType errorType, String ofStatic) {
		
		if(errorType==null)
		throw new ErrorTypeException("Error type cannot be null");
		
		return (ofStatic == null || ofStatic.trim().length() == 0) ? 
			errorType.toString(): errorType.toString().concat(ofStatic);

	}

}
