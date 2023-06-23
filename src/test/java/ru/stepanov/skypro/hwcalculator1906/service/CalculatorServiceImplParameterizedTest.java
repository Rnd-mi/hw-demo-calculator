package ru.stepanov.skypro.hwcalculator1906.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.stepanov.skypro.hwcalculator1906.service.CalculatorServiceImplTest.extractResult;

class CalculatorServiceImplParameterizedTest {
    private final CalculatorService out = new CalculatorServiceImpl();

    private static Stream<Arguments> provideNumsForPlus() {
        return Stream.of(
                Arguments.of(-10.0, 10.0, 0.0),
                Arguments.of(20.0, -20.0, 0.0),
                Arguments.of(41414141.0, -41414141.0, 0.0),
                Arguments.of(0.0, 0.0, 0.0)
        );
    }

    private static Stream<Arguments> provideNumsForMinus() {
        return Stream.of(
                Arguments.of(10.0, -100000.0, 100010.0),
                Arguments.of(2000.0, 20.0, 1980.0),
                Arguments.of(41141.0, 41.0, 41100.0),
                Arguments.of(55.0, 30.0, 25.0)
        );
    }

    private static Stream<Arguments> provideNumsForMultiply() {
        return Stream.of(
                Arguments.of(0.0, 10.0, 0.0),
                Arguments.of(20.0, 0.0, 0.0),
                Arguments.of(0.0, 41414141.0, 0.0),
                Arguments.of(0.0, 0.0, 0.0)
        );
    }


    private static Stream<Arguments> provideNumsForDivide() {
        return Stream.of(
                Arguments.of(10.0, 10.0, 1.0),
                Arguments.of(20.0, 20.0, 1.0),
                Arguments.of(41414141.0, 41414141.0, 1.0),
                Arguments.of(-1000000.4141, -1000000.4141, 1.0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideNumsForPlus")
    void plus_ShouldReturnZeroIfNumsAreOppositeAndIfZeroes(Double num1, Double num2, Double expected) {
        assertEquals(extractResult(out.plus(num1, num2)), expected);
    }

    @ParameterizedTest
    @MethodSource("provideNumsForMinus")
    void minus_ShouldReturnPositiveIfNum1IsPositiveAndBiggerThanNum2(Double num1, Double num2, Double expected) {
        assertEquals(extractResult(out.minus(num1, num2)), expected);
    }

    @ParameterizedTest
    @MethodSource("provideNumsForMultiply")
    void multiply_ShouldReturnZeroIfNumIsZeroOrBothAreZeroes(Double num1, Double num2, Double expected) {
        assertEquals(extractResult(out.multiply(num1, num2)), expected);
    }

    @ParameterizedTest
    @MethodSource("provideNumsForDivide")
    void multiply_ShouldReturnOneIfDividedByItself(Double num1, Double num2, Double expected) {
        assertEquals(extractResult(out.divide(num1, num2)), expected);
    }
}