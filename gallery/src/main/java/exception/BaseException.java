package exception;

import enums.ErrorType;

public class BaseException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	
	public BaseException(ErrorMessage errorMessage) {
		super(errorMessage.getErrorMessage());
	}


	public BaseException(String string) {
		// TODO Auto-generated constructor stub
	}


	public BaseException(ErrorType refreshTokenNotFound, String token) {
		// TODO Auto-generated constructor stub
	}


}
