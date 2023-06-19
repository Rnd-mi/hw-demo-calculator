package ru.stepanov.skypro.hwcalculator1906.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST,
                reason = "To execute this operation you MUST provide 2 numbers")
public class NoInputException extends IllegalArgumentException {
    public NoInputException() {
    }
}
