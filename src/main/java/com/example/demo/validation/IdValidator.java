package com.example.demo.validation;

import org.springframework.stereotype.Component;

@Component
public class IdValidator {

    public void validateId(Long id) {
        if (id == 0) {
            throw new IllegalArgumentException("ID cannot be null");
        }

        if (id <= 0) {
            throw new IllegalArgumentException("ID must be a positive value");
        }
    }
}
