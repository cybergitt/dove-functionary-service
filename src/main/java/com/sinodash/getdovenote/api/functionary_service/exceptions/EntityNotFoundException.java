package com.sinodash.getdovenote.api.functionary_service.exceptions;

public class EntityNotFoundException extends RuntimeException {
    private final String errorCode;

    public EntityNotFoundException (String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
