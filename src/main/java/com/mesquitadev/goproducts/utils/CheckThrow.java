package com.mesquitadev.goproducts.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CheckThrow {
    public static void checkThrow(Boolean expression, HttpStatus status, String message) {
        if(expression) {
            throw new ResponseStatusException(status, message);
        }
    }
}
