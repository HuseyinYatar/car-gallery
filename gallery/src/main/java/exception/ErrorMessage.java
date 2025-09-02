package exception;

import enums.ErrorType;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorMessage {

	private String ofStatic;

	private ErrorType errorType;

	public String getErrorMessage() {
		
		if(errorType==null)
		throw new BaseException("Error Type Cannot be null");
		
		return (ofStatic == null || ofStatic.trim().length() == 0) ? 
			errorType.toString(): errorType.toString().concat(ofStatic);

	}

	public ErrorMessage(ErrorType tokenNotFound) {
		// TODO Auto-generated constructor stub
	}

	public ErrorMessage(ErrorType usernameNotFound, String username) {
		// TODO Auto-generated constructor stub
	}

}
