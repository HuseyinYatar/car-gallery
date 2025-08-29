package enums;

public enum ErrorType {

	USER_NOT_FOUND("1001","The user you are looking for could not be found."),
	GENERAL_EXCEPTION("4444","A  general error occurred");
	
	private String code;
	
	private String message;

	 ErrorType(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
}
