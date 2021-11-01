package com.serenitydojo.calculator;

import com.google.common.base.Splitter;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class Calculator {
    public int evaluate(String expression) {
        if(expression.isEmpty()){
            return 0;
        }

        List<String> characters = Splitter.on(" ").splitToList(expression);

        int total = 0;
        String operator = "+";

        for(String character : characters){
            if(StringUtils.isNumeric(character)) {
                total = execute(total, operator, character);
            } else {
                operator =  character;
            }
        }

        return total;
    }

    private int execute(int total, String operator, String character) {
        switch (operator) {
            case "+":
                return total + Integer.parseInt(character);
            case "-":
                return total - Integer.parseInt(character);
            case "*":
                return total * Integer.parseInt(character);
            default:
                throw new IllegalMathsOperatorException("Operator " + operator + " not allowed");
        }
    }
}
