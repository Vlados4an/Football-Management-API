package ru.erma.footballapiup.util;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ValidationErrorResponse extends ErrorResponse {
    private Map<String, String> errors;
    public ValidationErrorResponse(String message, int status, long timestamp, Map<String, String> errors) {
        super(message, status, timestamp);
        this.errors = errors;
    }
}
