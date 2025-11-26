package com.sinodash.getdovenote.api.functionary_service.exceptions;

import java.time.Instant;
import java.util.List;

public record ValidationErrorResponse(
    Instant timestamp,
    int status,
    String error,
    List<FieldValidationError> errors
) {}
