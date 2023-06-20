package ru.stepanov.skypro.hwcalculator1906.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import static ru.stepanov.skypro.hwcalculator1906.constants.Constants.*;


public class CalculatorServiceImplTest {

    private final CalculatorService out = new CalculatorServiceImpl();

    private int extractResult(String string) {
        int result = -1;

        Pattern p = Pattern.compile("-?\\d+");
        Matcher m = p.matcher(string);
        int count = 0;

        while (m.find()) {

            if (count == 2) {
                result = Integer.parseInt(m.group());
            }
            count++;
        }
        return result;
    }

    @Test
    public void tenPlusNegativeTenShouldReturnZero() {
        int expected = ZERO;
        int actual = extractResult(out.plus(POSITIVE_TEN, NEGATIVE_TEN));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void negativePlusNegativeShouldReturnNegative() {
        int expected = NEGATIVE_TWENTY;
        int actual = extractResult(out.plus(NEGATIVE_TEN, NEGATIVE_TEN));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void negativeMinusNegativeShouldChangeTheSign() {
        int expected = ZERO;
        int actual = extractResult(out.minus(NEGATIVE_TEN, NEGATIVE_TEN));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ifNum2IsBiggerShouldReturnNegative() {
        int expected = -NINETY_NINE;
        int actual = extractResult(out.minus(ONE, HUNDRED));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnPositiveIfNegativeIsMultipliedByNegative() {
        int expected = HUNDRED;
        int actual = extractResult(out.multiply(NEGATIVE_TEN, NEGATIVE_TEN));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnZeroIfOneNumIsMultipliedByZero() {
        int expected = ZERO;
        int actual = extractResult(out.multiply(ZERO, POSITIVE_TEN));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnZeroIfZeroIsDividedByAnyNum2() {
        int expected = ZERO;
        int actual = extractResult(out.divide(ZERO, NEGATIVE_THOUSAND));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnPositiveIfNegativeIsDividedByNegative() {
        int expected = POSITIVE_TEN;
        int actual = extractResult(out.divide(-HUNDRED, NEGATIVE_TEN));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowIfDividerIsZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> out.divide(POSITIVE_TEN, ZERO));
    }
}