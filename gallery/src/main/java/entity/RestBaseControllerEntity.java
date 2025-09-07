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


	private T context;

	public static <T> RestBaseControllerEntity<T> ok(T context) {
		RestBaseControllerEntity<T> baseControllerEntity = 
				new RestBaseControllerEntity<T>(200, new Date(),context);
		return baseControllerEntity;

	}

	public static <T> RestBaseControllerEntity<T> error(T errorMessage) {
		RestBaseControllerEntity<T> baseControllerEntity =
				new RestBaseControllerEntity<T>(400, new Date(), errorMessage);
		return baseControllerEntity;

	}

	
}
