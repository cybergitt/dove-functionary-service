package com.sinodash.getdovenote.api.functionary_service.exceptions;

import java.time.Instant;

public record ErrorResponse(
    Instant timestamp,
    int status,
    String error,
    String message,
    String path,
    String errorCode
) {}
