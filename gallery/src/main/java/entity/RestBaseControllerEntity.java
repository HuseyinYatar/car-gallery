package entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
@JsonInclude(value = Include.NON_NULL)
public class RestBaseControllerEntity<T> {

	
	private Integer httpstatus;
	
	private Date timestamp;

	private String errorMessage;

	private T context;

	public static <T> RestBaseControllerEntity<T> ok(T context) {
		RestBaseControllerEntity<T> baseControllerEntity = 
				new RestBaseControllerEntity<T>(200, new Date(), null,context);
		return baseControllerEntity;

	}

	public static <T> RestBaseControllerEntity<T> error(String errorMessage) {
		RestBaseControllerEntity<T> baseControllerEntity =
				new RestBaseControllerEntity<T>(400, new Date(),errorMessage, null);
		return baseControllerEntity;

	}

	
}
