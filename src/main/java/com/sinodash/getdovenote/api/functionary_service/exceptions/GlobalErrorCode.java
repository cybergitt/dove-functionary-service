package com.sinodash.getdovenote.api.functionary_service.exceptions;

public class GlobalErrorCode {
    // 00000-09999 - Generic Error Codes
    public static final String ERROR_GENERIC = "503";
    public static final String ERROR_BAD_REQUEST = "400";
    public static final String ERROR_FORBIDDEN = "403";
    public static final String ERROR_NOT_FOUND = "404";
    public static final String ERROR_UNKNOWN = "410";

    // 10000-19999 - Specific Error Codes
    public static final String ERROR_RESOURCE_NOT_FOUND = "1001";
    public static final String ERROR_ENTITY_NOT_FOUND = "1002";
    public static final String ERROR_EMAIL_REGISTERED = "1003";
    public static final String ERROR_INVALID_EMAIL = "1004";
    public static final String ERROR_USER_NOT_FOUND = "1005";
}
