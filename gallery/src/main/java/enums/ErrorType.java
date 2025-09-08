package enums;


public enum ErrorType {
	NO_RECORD_EXISTS("1000","The record you are looking for could not be found."),
	USER_NOT_FOUND("1001","The user you are looking for could not be found."),
	USERNAME_NOT_FOUND("1002","The user you are looking for could not be found."),
	JWT_TOKEN_NOT_FOUND("2002","The jwt token is invalid."),
	REFRESH_TOKEN_NOT_FOUND("20003","The refresh token is invalid."),
	REFRESH_TOKEN_EXPIRED("2004","The refresh token is expired."),
	JWT_TOKEN_EXPIRED("20005","The jwt token is expired"),
	ERROR_OCCURED_IN_API_REQUEST("3000","An error occurred in api request"),
	NOT_HAVE_ENOUGH_MONEY("3001","The customer does not have enough money"),
	GENERAL_EXCEPTION("4444","A  general error occurred.");
	
	@SuppressWarnings("unused")
	private String code;
	
	@SuppressWarnings("unused")
	private String message;

	 ErrorType(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
}
