package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private String expression;
    private String operation = "";
    private String[] nums;

    private boolean roman = false;
    private boolean arabic = false;
    private int result;

    private ArrayList<Number> numbers = new ArrayList<>();

    public void readExpression() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            expression = reader.readLine();
            readOperation();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void readOperation() {
        Pattern oprtn = Pattern.compile("[-+*/]");
        Matcher m = oprtn.matcher(expression);
        try {
            while (m.find()) {
                if (!operation.equals(""))
                    throw new Exception("Вы ввели недопустимое количество арифметических операций.");
                switch (m.group()) {
                    case ("+"):
                        operation = "\\+";
                        break;
                    case ("-"):
                        operation = "-";
                        break;
                    case ("*"):
                        operation = "\\*";
                        break;
                    case ("/"):
                        operation = "/";
                        break;
                    default:
                        throw new Exception("Вы ввели недопустимую арифметическую операцию.");
                }
            }
            splitBySign();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void splitBySign() {
        nums = expression.split(operation);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i].trim();
        }
        createNumbers();
    }

    private void createNumbers() {
        try {
            if (nums.length == 2) {
                for (String s : nums) {
                    if (isStringInt(s)) {
                        if (!roman) {
                                numbers.add(new ArabicNumber(s));
                                arabic = true;
                        } else throw new Exception("Вы ввели недопустимое сочетание цифр.");
                    } else {
                        if (!arabic) {
                            numbers.add(new RomanNumber(s));
                            roman = true;
                        } else throw new Exception("Вы ввели недопустимое сочетание цифр.");
                    }
                }
            } else {
                throw new Exception("Вы ввели недопустимое количество чисел!");
            }
            calculateAndDisplayResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void calculateAndDisplayResult() throws Exception {
        result = calculation(numbers.get(0), operation, numbers.get(1));
        if (roman) {
            RomanNumber romanResult = new RomanNumber(result);
            System.out.println(romanResult.getNumber());
        } else {
            System.out.println(result);
        }
    }

    private boolean isStringInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private int calculation(Number num1, String oprtn, Number num2) {
        switch (oprtn) {
            case ("\\+"):
                result = (num1.getI() + num2.getI());
                break;
            case ("-"):
                result = (num1.getI() - num2.getI());
                break;
            case ("\\*"):
                result = (num1.getI() * num2.getI());
                break;
            case ("/"):
                result = (num1.getI() / num2.getI());
                break;
        }
        return result;
    }
}
