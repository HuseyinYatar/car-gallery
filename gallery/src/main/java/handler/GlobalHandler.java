package handler;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import exception.ApiError;
import exception.BaseException;
import exception.CustomException;

@ControllerAdvice
public class GlobalHandler {

	@ExceptionHandler(exception = BaseException.class)
	private ResponseEntity<ApiError<String>> baseExceptionHandler(BaseException baseException, WebRequest webRequest) {
		return ResponseEntity.badRequest().body(createApiError(baseException.getMessage(), webRequest));
	}

	private String getHostName() {
		try {
			return Inet4Address.getLocalHost().getHostName().toString();
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return "";

		}
	}

	private <T> ApiError<T> createApiError(T message, WebRequest webRequest) {

		ApiError<T> apiError = new ApiError<>();
		apiError.setStatus(HttpStatus.BAD_REQUEST.value());

		CustomException<T> customException =  new CustomException<T>();
		customException.setHostName(getHostName());
		customException.setIssuedDate(new Date());
		customException.setMessagError(message);
		customException.setPath(webRequest.getDescription(false));

		
		apiError.setCustomException(customException);
		return apiError;
	}
}
