package org.unc.hexagonal.msvc_productos.application.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) { super(message); }
}

