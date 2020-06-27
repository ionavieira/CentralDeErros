package br.com.codenation.exception;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private final String detail;
    private final Integer status;

    public ApiException(String message, String detail, Integer status) {
        super(message);
        this.detail = detail;
        this.status = status;
    }

}
