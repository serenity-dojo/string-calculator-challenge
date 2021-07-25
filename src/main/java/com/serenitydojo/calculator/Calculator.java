package com.serenitydojo.calculator;

public class Calculator {
    public int evaluate(String expression) {

        String operators[] = expression.replaceAll("\\s", "").split("[0-9]+");
        String operands[] = expression.replaceAll("\\s", "").split("[*/+-]");

        int runningTotal = Integer.parseInt(operands[0]);

        for(int i=1; i<operands.length; i++) {
            if(operators[i].equals("+")) {
                runningTotal += Integer.parseInt(operands[i]);
            }
            else if(operators[i].equals("-")) {
                runningTotal -= Integer.parseInt(operands[i]);
            }
            else if(operators[i].equals("*")) {
                runningTotal *= Integer.parseInt(operands[i]);
            }
            else if(operators[i].equals("/")) {
                runningTotal /= Integer.parseInt(operands[i]);
            }
            else
            {
                throw new IllegalMathsOperatorException("Unknown operator ");
            }
        }
        return runningTotal;
    }

}
