package com.serenitydojo.calculator;

import org.apache.commons.lang3.StringUtils;

public class Calculator {
    public int evaluate(String expression) {
        if(expression.isEmpty()) {
            return 0;
        }

        int calculationResult = 0;
        String currentOperator = "+";

        String[] characters = expression.split("\\s");

        for(String character : characters) {
            if (!StringUtils.isNumeric(character)) {
                currentOperator = character;
            } else {
                calculationResult = calculation(calculationResult, currentOperator, character);
            }
        }
        return calculationResult;
    }

    private int calculation(int calculationResult, String currentOperator, String character) throws IllegalMathsOperatorException {
        switch(currentOperator) {
            case "+":
                return calculationResult + Integer.parseInt(character);
            case "-":
                return calculationResult - Integer.parseInt(character);
            case "*":
                return calculationResult * Integer.parseInt(character);
            case "/":
                return calculationResult / Integer.parseInt(character);
            default:
                throw new IllegalMathsOperatorException(currentOperator + " operator is not supported!");
        }
    }
}