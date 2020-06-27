package br.com.codenation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(ApiException.class)
	public ResponseEntity<ResponseError> expectError(ApiException e, WebRequest webRequest) {
		ResponseError response = new ResponseError(e.getMessage(), e.getDetail(), System.currentTimeMillis(),
				webRequest.getDescription(true));
		return new ResponseEntity<ResponseError>(response, HttpStatus.valueOf(e.getStatus()));
	}

}
