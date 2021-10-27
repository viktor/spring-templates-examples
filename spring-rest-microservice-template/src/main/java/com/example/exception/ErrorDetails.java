package com.example.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ErrorDetails Dto
 */
@Data @NoArgsConstructor @AllArgsConstructor
public class ErrorDetails {
    private String code, message;
}
