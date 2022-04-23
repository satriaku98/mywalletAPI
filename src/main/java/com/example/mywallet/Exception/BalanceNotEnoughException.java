package com.example.mywallet.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BalanceNotEnoughException extends RuntimeException{
    public BalanceNotEnoughException(String message) {
        super(message);
    }
}
