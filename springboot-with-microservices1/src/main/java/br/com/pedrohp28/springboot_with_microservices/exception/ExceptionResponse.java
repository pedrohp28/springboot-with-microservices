package br.com.pedrohp28.springboot_with_microservices.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {}
