package meli.bootcamp.practicaspring.config;

import meli.bootcamp.practicaspring.Exceptions.ApiError;
import meli.bootcamp.practicaspring.Exceptions.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<ApiError> badRequest(MissingServletRequestParameterException ex) {
		return new ResponseEntity<>(new ApiError("001","Bad request", HttpStatus.BAD_REQUEST.value())
				, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ApiError> badRequest(ConstraintViolationException ex) {
		return new ResponseEntity<>(new ApiError("002","Bad request", HttpStatus.BAD_REQUEST.value())
				, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ApiException.class)
	public ResponseEntity<ApiError> badRequest(ApiException ex) {

		return new ResponseEntity<>(new ApiError(ex.getCode(),"bad request", ex.getStatusCode())
				, HttpStatus.BAD_REQUEST);
	}


}