package com.serenitydojo.calculator;
import java.util.Arrays;
import java.util.List;
import static org.apache.commons.lang3.StringUtils.isNumeric;

public class Calculator {

    public int evaluate(String expression) {
        //String[] expressionToArray = expression.split(" ");

        if (expression.isEmpty()) {
            return 0;
        }

        String[] tokens = expression.split(" ");

        int currTotal = 0;
        String nextOperator = "+";

        for (String token : tokens) {
            if (!isNumeric(token)) {
                nextOperator = token;

            } else {
                currTotal = process(currTotal,nextOperator,token);

            }
        }
        return currTotal;
    }

        private int process(int currTotal, String nextOperator, String token) {
            switch (nextOperator){
                case "+":
                    return  currTotal + Integer.parseInt(token);
                case "-":
                    return  currTotal - Integer.parseInt(token);
                case "*":
                    return  currTotal * Integer.parseInt(token);
                case "/":
                    return  currTotal / Integer.parseInt(token);
                default:
                    throw new IllegalMathsOperatorException("Unknown operator " + nextOperator);
            }
        }
}




