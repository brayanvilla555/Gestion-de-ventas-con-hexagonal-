package org.unc.hexagonal.msvc_productos.application.exceptions;


public class BusinessException extends RuntimeException {
    public BusinessException(String message) { super(message); }
}