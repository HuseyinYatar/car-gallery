package handler;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import controller.RestBaseController;
import entity.RestBaseControllerEntity;
import exception.ApiError;
import exception.BaseException;
import exception.CustomException;

@ControllerAdvice
public class GlobalHandler extends RestBaseController {

	@ExceptionHandler(exception = BaseException.class)
	private ResponseEntity<RestBaseControllerEntity<ApiError<String>>> baseExceptionHandler(BaseException baseException, WebRequest webRequest) {
		return ResponseEntity.badRequest().body(error(createApiError(baseException.getMessage(), webRequest)));
	}

	@ExceptionHandler(exception = MethodArgumentNotValidException.class)
	private ResponseEntity<RestBaseControllerEntity<ApiError<HashMap<String, Object>>>> handleValidationException(MethodArgumentNotValidException ex, WebRequest webRequest) {
		HashMap<String, Object> map = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldname = ((FieldError) error).getField();
			String errorname = ((ObjectError) error).getDefaultMessage();
			map.put(fieldname, errorname);
		});

		return ResponseEntity.badRequest().body(error(createApiError(map, webRequest)));
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

		CustomException<T> customException = new CustomException<T>();
		customException.setHostName(getHostName());
		customException.setMessagError(message);
		customException.setPath(webRequest.getDescription(false));

		apiError.setCustomException(customException);
		return apiError;
	}
}
