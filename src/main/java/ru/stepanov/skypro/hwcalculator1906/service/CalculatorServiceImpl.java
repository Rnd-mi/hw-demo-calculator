package ru.stepanov.skypro.hwcalculator1906.service;

import org.springframework.stereotype.Service;
import ru.stepanov.skypro.hwcalculator1906.exceptions.DividedByZeroException;
import ru.stepanov.skypro.hwcalculator1906.exceptions.NoInputException;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    void checkIfNull(Double num1, Double num2) {
        if (num1 == null || num2 == null) {
            throw new NoInputException();
        }
    }

    private String numberHandler(Double num) {

        if (num < 0) {
            return "(" + num + ")";
        }
        return num + "";
    }

    private String generateOperation(Double num1, Double num2, String operation) {
        String sign = "";

        switch (operation) {
            case "plus":
                sign = " + ";
                break;
            case "minus":
                sign = " - ";
                break;
            case "multiply":
                sign = " * ";
                break;
            case "divide":
                sign = " / ";
                break;
        }
        return numberHandler(num1) + sign + numberHandler(num2) + " = ";
    }

    @Override
    public String plus(Double num1, Double num2) {
        checkIfNull(num1, num2);
        double result = num1 + num2;
        return generateOperation(num1, num2, "plus") + result;
    }

    @Override
    public String minus(Double num1, Double num2) {
        checkIfNull(num1, num2);
        double result = num1 - num2;
        return generateOperation(num1, num2, "minus") + result;
    }

    @Override
    public String multiply(Double num1, Double num2) {
        checkIfNull(num1, num2);
        double result = num1 * num2;
        return generateOperation(num1, num2, "multiply") + result;
    }

    @Override
    public String divide(Double num1, Double num2) {
        checkIfNull(num1, num2);

        if (num2 == 0) {
            throw new DividedByZeroException();
        }
        double result = num1 / num2;
        return  generateOperation(num1, num2, "divide") + result;
    }
}
