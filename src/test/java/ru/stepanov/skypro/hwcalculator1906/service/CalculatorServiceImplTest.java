package ru.stepanov.skypro.hwcalculator1906.service;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CalculatorServiceImplTest {

    private final CalculatorServiceImpl out = new CalculatorServiceImpl();

    /**
     * Extracts the result out of String to be able to test only the double result.
     * @param string message from the endpoint
     * @return extracted double result
     */
    static double extractResult(String string) {
        double result = -1;

        Pattern p = Pattern.compile("-?\\d+\\.\\d+");
        Matcher m = p.matcher(string);
        int count = 0;

        while (m.find()) {

            if (count == 2) {
                result = Double.parseDouble(m.group());
            }
            count++;
        }
        return result;
    }

    @Test
    public void tenPlusNegativeTenShouldReturnZero() {
        double expected = 0;
        double actual = extractResult(out.plus(10.0, -10.0));
        assertEquals(expected, actual);
    }

    @Test
    public void negativePlusNegativeShouldReturnNegative() {
        double expected = -20;
        double actual = extractResult(out.plus(-10.0, -10.0));
        assertEquals(expected, actual);
    }

    @Test
    public void negativeMinusNegativeShouldChangeTheSign() {
        double expected = 0;
        double actual = extractResult(out.minus(-10.0, -10.0));
        assertEquals(expected, actual);
    }

    @Test
    public void ifNum2IsBiggerShouldReturnNegative() {
        double expected = -9;
        double actual = extractResult(out.minus(1.0, 10.0));
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnPositiveIfNegativeIsMultipliedByNegative() {
        double expected = 100.0;
        double actual = extractResult(out.multiply(-10.0, -10.0));
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnZeroIfOneNumIsMultipliedByZero() {
        double expected = 0;
        double actual = extractResult(out.multiply(0.0, 10.0));
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnZeroIfZeroIsDividedByAnyNum2() {
        double expected = -0.0;
        double actual = extractResult(out.divide(0.0, -5615110.0));
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnPositiveIfNegativeIsDividedByNegative() {
        double expected = 1.0;
        double actual = extractResult(out.divide(-10.0, -10.0));
        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowIfDividerIsZero() {
        assertThrows(IllegalArgumentException.class, () -> out.divide(10.0, 0.0));
    }

    @Test
    public void plus_shouldThrowIfNullProvided() {
        assertThrows(IllegalArgumentException.class, () -> out.checkIfNull(null, 31.0));
    }
}
