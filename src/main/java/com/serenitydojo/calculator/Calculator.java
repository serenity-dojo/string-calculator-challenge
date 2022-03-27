package com.serenitydojo.calculator;

import static org.apache.commons.lang3.StringUtils.isNumeric;

public class Calculator {
    private String operator = "";
    private int evaluation = 0;

    public int evaluate(String expression) {
        if (!expression.isEmpty()) {
            return iteratingThrewTheExpression(expression);
        }

        return 0;
    }

    private int doingTheOperation( int number1, int number2) {
        switch (this.operator) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "/":
                return number1 / number2;
            case "*":
                return number1 * number2;
            default:
                return number1;
        }
    }

    private int iteratingThrewTheExpression(String expression) {
        String[] elements = expression.split(" ");
            for (String element : elements) {
                preparingTheCalculation(element);
            }

            return this.evaluation;
    }

    private void preparingTheCalculation(String element) {
        int number1 = 0;
        int number2 = 0;

        if (isNumeric(element)) {
            int[] intFromString = gettingIntFromString(element);
            this.evaluation = doingTheOperation(intFromString[0], intFromString[1]);
        } else {
            this.operator = element;
        }
    }


    private int[] gettingIntFromString(String element) {
        int[] numberFromString = new int[2];
        int number2 = 0;

        if(this.evaluation == 0) {
            int number1 = Integer.parseInt(element);
            if(number1 != 0 && number2 != 0) {
                number1 = this.evaluation;
            }
            numberFromString[0] = number1;
        }
        else {
            number2 = Integer.parseInt(element);

            if(this.evaluation != 0) {
                numberFromString[0] = this.evaluation;
            }
            numberFromString[1] = number2;
        }
        return numberFromString;
    }

}



