package meli.bootcamp.practicaspring.Exceptions;

import lombok.Data;

@Data
public class ApiError {

	private String error;
	private String message;
	private Integer status;

	public ApiError(String error, String message, Integer status) {
		this.error = error;
		this.message = message;
		this.status = status;
	}

	@Override
	public String toString() {
		return "{" +
				"'error': '" + error + '\'' +
				", 'message': '" + message + '\'' +
				", 'status': '" + status + "'}";
	}
}