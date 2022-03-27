package com.serenitydojo.calculator;

import static org.apache.commons.lang3.StringUtils.isNumeric;

public class Calculator {

    public int evaluate(String expression) {
        int evaluation = 0;

        if (!expression.isEmpty()) {
            String[] elements = expression.split(" ");
            int number1 = 0;
            int number2 = 0;
            int res = 0;
            String operator = "";
            boolean firstTime = true;

            for (String element : elements) {
                if (isNumeric(element)) {
                    if(firstTime == true) {
                        number1 = Integer.parseInt(element);
                        firstTime = false;
                        if(res != 0) {
                            int intervertion = 0;
                            intervertion = number1;
                            number1 = res;
                            number2 = intervertion;
                        }
                    }
                    else {
                        number2 = Integer.parseInt(element);
                        firstTime = true;

                        if(res != 0) {
                            number1 = res;
                        }
                    }

                    switch (operator) {
                        case "+":
                            res = res + number2;
                            break;
                        case "-":
                            res = res - number2;
                            break;
                        case "/":
                            res = res / number2;
                            break;
                        case "*":
                            res = res * number2;
                            break;
                        default:
                            res = number1 ;
                            break;
                    }
                    evaluation = res;
                } else {
                    operator = element;
                }
            }
        }

        return evaluation;
    }


}



