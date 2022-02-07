package com.serenitydojo.calculator;

/**
 * Order of precedence of mathematical operations in an Expression.
 * Parentheses, Exponents, Multiplication/Division, Addition/Subtraction. PEMDAS
 * is often expanded to the mnemonic "Please Excuse My Dear Aunt Sally" in schools.
 *
 *
 * Step1: First need to calculate the Parentheses, Exponents, Multiplication/Division,
 *        Addition/Subtraction.
 * Step2: Implementation login will vary from format of the string we use. based on Splitting the string OR
 *        from the length of the string and going through each character
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.isNumeric;

/**
 * # String Calculator Challenge
 *
 * The aim of this challenge is to implement a simple integer calculator. The calculator takes a string of
 * space-separated numbers and operators (like "1 + 2 + 3" or "10 + 4 - 5") and returns the result of the calculation.
 *
 * It should resolve the following sums:
 *
 * - "1"
 * - "1 + 1"
 * - "1 + 2 + 3"
 * - "10 - 6"
 * - "10 + 5 - 6"
 * - "10 * 5"
 *
 * If an operator isn't known, an exception should be thrown.
 *
 *
 */

public class Calculator {
    /**
     * @param stringNumericalExpression is a string expression
     * - "1"
     * * - "1 + 1"
     * * - "1 + 2 + 3"
     * * - "10 - 6"
     * * - "10 + 5 - 6"
     * * - "10 * 5"
     * @return : returns the result of the calculation.
     */

    private static final String WHITESPACE = "\\s";

    public Number evaluate(String stringNumericalExpression) {


        if (stringNumericalExpression.isEmpty() || stringNumericalExpression.isBlank()) {
            return 0;
        }
        // 1.
        List<String> toCalculateItems = List.of((stringNumericalExpression.split(WHITESPACE)))
                .stream().filter(element -> !element.isEmpty())
                .collect(Collectors.toList());
        // 2.
        List<String> toCalculateItems1 = Arrays.stream(stringNumericalExpression.split(WHITESPACE))
                .filter(item -> !item.isEmpty())
                .collect(Collectors.toList());


        int successiveTotal = 0;
        String nextOperator = "+";


        for (String toCalculateItem : toCalculateItems) {
            System.out.println(" toCalculateItem :  " + toCalculateItem);
               if(!isNumeric(toCalculateItem)){
                   nextOperator = toCalculateItem;
               }else{
                   successiveTotal = calculateExpression(successiveTotal,nextOperator,toCalculateItem);
               }

        }
        return successiveTotal;
    }

    private int calculateExpression(int successiveTotal, String nextOperator, String toCalculateItem) {
        switch (nextOperator){
            case "+":
                return successiveTotal + Integer.parseInt(toCalculateItem);
            case "-":
                return successiveTotal - Integer.parseInt(toCalculateItem);
            case "*":
                return successiveTotal * Integer.parseInt(toCalculateItem);
            default:
                throw new IllegalMathsOperatorException("UnKnown Operator" +nextOperator);
        }
    }
}
