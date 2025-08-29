package exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class CustomException<T> {

	private T messagError;

	private String hostName;

	private Date issuedDate;

	private String path;

}
