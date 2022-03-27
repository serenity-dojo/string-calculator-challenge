package com.serenitydojo.calculator;

import static org.apache.commons.lang3.StringUtils.isNumeric;

public class Calculator {

    public int evaluate(String expression) {
        if (!expression.isEmpty()) {
            return preparingTheCalculation(expression);
        }

        return 0;
    }


    private int doingTheOperation(String operator, int number1, int number2) {
        switch (operator) {
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

    private int preparingTheCalculation(String expression) {
            int evaluation = 0;
            String[] elements = expression.split(" ");
            int number1 = 0;
            int number2 = 0;
            String operator = "";
            boolean firstTime = true;

            for (String element : elements) {
                if (isNumeric(element)) {
                    if(firstTime == true) {
                        number1 = Integer.parseInt(element);
                        firstTime = false;
                        if(number1 != 0 && number2 != 0) {
                            int intervertion = 0;
                            intervertion = number1;
                            number1 = evaluation;
                            number2 = intervertion;
                        }
                    }
                    else {
                        number2 = Integer.parseInt(element);
                        firstTime = true;

                        if(number1 != 0) {
                            number1 = evaluation;
                        }
                    }

                    evaluation = doingTheOperation(operator, number1, number2);
                } else {
                    operator = element;
                }
            }

            return evaluation;
    }




}



