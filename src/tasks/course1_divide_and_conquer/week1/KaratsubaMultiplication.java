package tasks.course1_divide_and_conquer.week1;

import java.math.BigDecimal;

class KaratsubaMultiplication {

    public static BigDecimal karatsubaMultiplication(BigDecimal x, BigDecimal y) {
        int xLen = x.toString().length();
        int yLen = y.toString().length();
        if (xLen == 1 || yLen == 1) {
            return x.multiply(y);
        }
        int n = Math.max(xLen, yLen);
        for (int i = 0; Math.pow(2, i) != n;) {
            if (Math.pow(2, i) < n) {
                i++;
            } else {
                n++;
            }
        }
        String numberX = x.toString();
        for (int i = n; i > x.toString().length(); i--) {
            numberX = "0" + numberX;
        }
        String numberY = y.toString();
        for (int i = n; i > y.toString().length(); i--) {
            numberY = "0" + numberY;
        }

        BigDecimal a = new BigDecimal(numberX.substring(0, numberX.length() / 2));
        BigDecimal b = new BigDecimal(numberX.substring(numberX.length() / 2));
        BigDecimal c = new BigDecimal(numberY.substring(0, numberY.length() / 2));
        BigDecimal d = new BigDecimal(numberY.substring(numberY.length() / 2));

        BigDecimal first = karatsubaMultiplication(a, c);
        BigDecimal second = karatsubaMultiplication(b, d);
        BigDecimal third = karatsubaMultiplication(a.add(b), c.add(d));
        BigDecimal fourth = third.add(second.negate()).add(first.negate());

        String firstTenN = first.toString();
        for (int i = 0; i < n; i++) {
            firstTenN += "0";
        }
        String fourthTenNDivide2 = fourth.toString();
        for (int i = 0; i < n / 2; i++) {
            fourthTenNDivide2 += "0";
        }

        BigDecimal result = new BigDecimal(firstTenN)
                .add(second)
                .add(new BigDecimal(fourthTenNDivide2));
        return result;
    }
}
