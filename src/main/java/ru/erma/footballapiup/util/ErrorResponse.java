package ru.erma.footballapiup.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ErrorResponse {
    private String message;
    private int status;
    private long timestamp;
}
