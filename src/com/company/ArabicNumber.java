package com.company;

public class ArabicNumber extends Number {

    public ArabicNumber(String number) throws Exception {
            int n = Integer.parseInt(number);
            if ((n > 0 && n < 11) && !number.contains(".")) {
                super.setI(n);
            } else {
                throw new Exception("Вы вышли за пределы допустимого диапазона значений!");
            }
    }
}
