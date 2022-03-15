package com.serenitydojo.calculator;



public class Calculator {
    public static int evaluate(String str) throws Exception {
        str = str.replace(" ", "");
        if (str.isEmpty()) {
            return 0;
        } else if (str.length() == 1){
            return Integer.parseInt(str);
        }
        else

        {
            // will get all numbers and store it to `numberStr`
            String numberStr[] = str.replaceAll("[+*/()-]+", " ").split(" ");
            // will get all operators and store it to `operatorStr`
            String operatorStr[] = str.replaceAll("[0-9()]+", "").split("");

            int total = Integer.parseInt(numberStr[0]);

            for (int i = 0; i < operatorStr.length; i++) {
                switch (operatorStr[i]) {
                    case "+":
                        total += Integer.parseInt(numberStr[i + 1]);
                        break;
                    case "-":
                        total -= Integer.parseInt(numberStr[i + 1]);
                        break;
                    case "*":
                        total *= Integer.parseInt(numberStr[i + 1]);
                        break;
                    case "/":
                        total /= Integer.parseInt(numberStr[i + 1]);
                        break;
                    case "^":
                        throw new Exception("Unexpected operator" + operatorStr[i]);
                }

                if (i + 2 >= operatorStr.length) continue; // if meets the last operands already
                numberStr[i + 1] = String.valueOf(total);

            }
            return Integer.parseInt(String.valueOf(total));
        }
    }
}
