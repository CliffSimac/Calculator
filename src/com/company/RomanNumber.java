package com.company;

public class RomanNumber extends Number {
    private String number;


    public void setNumber(String number) {
        this.number = number;
    }
    public String getNumber() {
        return number;
    }

    public RomanNumber(String number) throws Exception {
            for (int i = 0; i < 100; i++) {
                if (roman[i].equals(number)) {
                    setNumber(number);
                    super.setI(arabic[i]);
                    break;
                }
            }
            if (getI() == 0) throw new Exception("Недопустимое значение или значение вышло за " +
                    "пределы допустимого диапазона!");
    }

    public RomanNumber(int number) throws Exception {
            for (int i = 0; i < 100; i++) {
                if (arabic[i] == number) {
                    setNumber(roman[i]);
                    super.setI(arabic[i]);
                    break;
                }
            }
            if (getNumber() == null) throw new Exception("Недопустимое значение или значение вышло за " +
                    "пределы допустимого диапазона!");
    }

    public final int[] arabic = {100,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,
            21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,
            41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,
            61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,
            81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99};

    public final String[] roman = {"C","I","II","III","IV","V","VI","VII","VIII","IX",
            "X","XI","XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX",
            "XX","XXI","XXII","XXIII","XXIV","XXV","XXVI","XXVII","XXVIII","XXIX",
            "XXX","XXXI","XXXII","XXXIII","XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX",
            "XL","XLI","XLII","XLIII","XLIV","XLV","XLVI","XLVII","XLVIII","XLIX",
            "L","LI","LII","LIII","LIV","LV","LVI","LVII","LVIII","LIX",
            "LX","LXI","LXII","LXIII","LXIV","LXV","LXVI","LXVII","LXVIII","LXIX",
            "LXX","LXXI","LXXII","LXXIII","LXXIV","LXXV","LXXVI","LXXVII","LXXVIII","LXXIX",
            "LXXX","LXXXI","LXXXII","LXXXIII","LXXXIV","LXXXV","LXXXVI","LXXXVII","LXXXVIII","LXXXIX",
            "XC","XCI","XCII","XCIII","XCIV","XCV","XCVI","XCVII","XCVIII","XCIX"};
}
