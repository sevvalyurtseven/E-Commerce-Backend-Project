package com.workintech.ecommerce.backend.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class CategoryException extends RuntimeException {

    private HttpStatus httpStatus;

    public CategoryException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

}