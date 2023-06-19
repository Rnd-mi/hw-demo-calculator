package ru.stepanov.skypro.hwcalculator1906.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.stepanov.skypro.hwcalculator1906.service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String greeting() {
        return "Hello, this is demo calculator";
    }

    @GetMapping("/plus")
    public String plus(Integer num1, Integer num2) {
        return calculatorService.plus(num1, num2);
    }

    @GetMapping("/minus")
    public String minus(Integer num1, Integer num2) {
        return calculatorService.minus(num1, num2);
    }

    @GetMapping("/divide")
    public String divide(Integer num1, Integer num2) {
        return calculatorService.divide(num1, num2);
    }

    @GetMapping("/multiply")
    public String multiply(Integer num1, Integer num2) {
        return calculatorService.multiply(num1, num2);
    }
}
