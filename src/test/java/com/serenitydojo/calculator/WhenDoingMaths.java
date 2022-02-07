package com.serenitydojo.calculator;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenDoingMaths {
    Calculator calculator = new Calculator();

    @Test
    public void shouldReturnZeroForAnEmptyString() {
        assertThat(calculator.evaluate("")).isEqualTo(0);
    }

    @Test(expected = IllegalMathsOperatorException.class)
    public void shouldReportNonSupportedOperations() {
        calculator.evaluate("1 ^ 2");
    }

    @Test
    public void shouldReturnTheValueOfASingleNumber() {
        Number result = calculator.evaluate(" 1 ");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void shouldAddTwoNumbers() {
        Number result = calculator.evaluate("1 + 1");
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void shouldAddThreeNumbers() {
        Number result = calculator.evaluate("1 + 2 + 3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void shouldAlsoSubtract() {
        Number result = calculator.evaluate("10 - 6");
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void shouldAddAndSubtract() {
        Number result = calculator.evaluate("10 + 5 - 6");
        assertThat(result).isEqualTo(9);
    }

    @Test
    public void shouldMultiplyNumbers() {
        Number result = calculator.evaluate("10 * 5");
        assertThat(result).isEqualTo(50);
    }
}
