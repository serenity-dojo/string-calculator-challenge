package com.serenitydojo.calculator;

import com.serenitydojo.Exceptions.IllegalMathsOperatorException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    public int evaluate(String expression) {
        List<String> splittedExpression = Arrays.stream(expression.split(" ")).collect(Collectors.toList());
        List<String> operands = List.of("1","2","3","4","5","6","7","8","9","0");

        int expressionTotal =0;
        String operand ="+";

        if (expression.isEmpty()) {
            return 0;
        }
        for(String character : splittedExpression) {
            if (!operands.contains(character)) {
                operand = character;
            } else {
                expressionTotal = calculateOperation(expressionTotal, operand, character);
            }
        }
        return expressionTotal;
    }

    private int calculateOperation(int total, String operand, String token) {
        switch (operand) {
            case "+":
                return total + Integer.parseInt(token);
            case "-":
                return total - Integer.parseInt(token);
            case "*":
                return total * Integer.parseInt(token);
            default:
                throw new IllegalMathsOperatorException(operand + "Does not exist");
        }
    }
}

