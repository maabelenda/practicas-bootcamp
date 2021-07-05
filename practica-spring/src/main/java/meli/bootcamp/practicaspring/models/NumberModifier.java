package meli.bootcamp.practicaspring.models;


import lombok.Data;

@Data
public class NumberModifier {

    private static final char M = 'M', D = 'D', C = 'C', L = 'L', X = 'X', V = 'V', I = 'I';

    private String romanNumber;
    private String decimalNumber;

    public String decimalToRoman() {
        int number = Integer.valueOf(this.decimalNumber);

        int divider = 1000;
        int thousands = number / divider;

        StringBuffer response = new StringBuffer();

        for(int i = 1 ; i <= thousands ; i++) {
            response.append("M");
        }

        divider /= 10;
        response.append(decimalToRoman(number / divider % 10,"M", "D", "C"));
        divider /= 10;
        response.append(decimalToRoman(number / divider % 10,"C", "L", "X"));
        divider /= 10;
        response.append(decimalToRoman(number / divider % 10,"X", "V", "I"));

        return response.toString();

    }
    private String decimalToRoman(int number, String s1, String s2, String s3) {

        StringBuffer resp = new StringBuffer();
        if (number == 9) {
            resp.append(s3+s1);
        } else if (number >= 5) {
            resp.append(s2);
            for (int i = 6; i <= number; i++) {
                resp.append(s3);
            }
        } else if (number == 4) {
            resp.append(s3+s2);
        } else {
            for (int i = 1; i <= number; i++) {
                resp.append(s3);
            }
        }
        return resp.toString();
    }

    public Integer romanToDecimal() {
        int decimal = 0;
        int lastNumber = 0;
        String romanNumeral = this.romanNumber;

        for (int i = romanNumeral.length() - 1; i >= 0 ; i--) {
            char convertToDecimal = romanNumeral.charAt(i);

            switch (convertToDecimal) {
                case 'M':
                    decimal = processDecimal(1000, lastNumber, decimal);
                    lastNumber = 1000;
                    break;

                case 'D':
                    decimal = processDecimal(500, lastNumber, decimal);
                    lastNumber = 500;
                    break;

                case 'C':
                    decimal = processDecimal(100, lastNumber, decimal);
                    lastNumber = 100;
                    break;

                case 'L':
                    decimal = processDecimal(50, lastNumber, decimal);
                    lastNumber = 50;
                    break;

                case 'X':
                    decimal = processDecimal(10, lastNumber, decimal);
                    lastNumber = 10;
                    break;

                case 'V':
                    decimal = processDecimal(5, lastNumber, decimal);
                    lastNumber = 5;
                    break;

                case 'I':
                    decimal = processDecimal(1, lastNumber, decimal);
                    lastNumber = 1;
                    break;
            }
        }

        return decimal;
    }

    public Integer processDecimal(Integer decimal, Integer lastNumber, Integer lastDecimal) {
        if (lastNumber > decimal) {
            return lastDecimal - decimal;
        } else {
            return lastDecimal + decimal;
        }
    }

}
