package enums;


public enum ErrorType {

	USER_NOT_FOUND("1001","The user you are looking for could not be found."),
	USERNAME_NOT_FOUND("1002","The user you are looking for could not be found."),
	JWT_TOKEN_NOT_FOUND("2002","The jwt token is invalid."),
	REFRESH_TOKEN_NOT_FOUND("20003","The refresh token is invalid."),
	REFRESH_TOKEN_EXPIRED("2004","The refresh token is expired."),
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
