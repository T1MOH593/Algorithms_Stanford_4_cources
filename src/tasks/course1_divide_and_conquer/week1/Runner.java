package tasks.course1_divide_and_conquer.week1;

import java.math.BigDecimal;

import static tasks.course1_divide_and_conquer.week1.KaratsubaMultiplication.karatsubaMultiplication;

public class Runner {

    public static void main(String[] args) {
        System.out.println(karatsubaMultiplication(new BigDecimal("3141592653589793238462643383279502884197169399375105820974944592"),
                new BigDecimal("2718281828459045235360287471352662497757247093699959574966967627")));
    }
}
