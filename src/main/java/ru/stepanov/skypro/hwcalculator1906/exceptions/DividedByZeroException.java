package ru.stepanov.skypro.hwcalculator1906.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST,
                reason = "Dividing by zero is prohibited")
public class DividedByZeroException extends IllegalArgumentException {
    public DividedByZeroException() {
    }
}
