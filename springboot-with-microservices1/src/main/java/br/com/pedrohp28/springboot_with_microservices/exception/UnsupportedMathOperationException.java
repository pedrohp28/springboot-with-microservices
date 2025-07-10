package br.com.pedrohp28.springboot_with_microservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationException extends RuntimeException {
  public UnsupportedMathOperationException(String message) {
    super(message);
  }
}
