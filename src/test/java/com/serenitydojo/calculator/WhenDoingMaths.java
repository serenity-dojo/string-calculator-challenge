package com.serenitydojo.calculator;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import javax.script.ScriptException;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenDoingMaths {
    Calculator calculator = new Calculator();

    @Test
    public void shouldReturnZeroForAnEmptyString() throws Exception {
        assertThat(calculator.evaluate("")).isEqualTo(0);
    }
//
    @Test
    public void shouldReportNonSupportedOperations() throws Exception {
        calculator.evaluate("1 ^ 2");
    }
//
    @Test
    public void shouldReturnTheValueOfASingleNumber() throws Exception {
        assertThat(calculator.evaluate("1")).isEqualTo(1);
    }
////
    @Test
    public void shouldAddTwoNumbers() throws Exception {
        assertThat(calculator.evaluate("1 + 1")).isEqualTo(2);
    }
//
    @Test
    public void shouldAddThreeNumbers() throws Exception {
        assertThat(calculator.evaluate("1 + 2 + 3")).isEqualTo(6);
    }

    @Test
    public void shouldAlsoSubtract() throws Exception {
        assertThat(calculator.evaluate("10 - 6")).isEqualTo(4);
    }

    @Test
    public void shouldAddAndSubtract() throws Exception {
        assertThat(calculator.evaluate("10 + 5 - 6")).isEqualTo(9);
    }

    @Test
    public void shouldMultiplyNumbers() throws Exception {
        assertThat(calculator.evaluate("10 * 5")).isEqualTo(50);
    }
}
