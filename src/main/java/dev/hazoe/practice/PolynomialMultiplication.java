package dev.hazoe.practice;

import java.util.Arrays;

public class PolynomialMultiplication {

    /*
    (2x+1)(3x+4) = A[]*B[]
    A[0] * B[0] -> result[0]
    A[0] * B[1] -> result[1]
    A[1] * B[0] -> result[1]
    A[1] * B[1] -> result[2]
     */
    public static int[] multiply(int[] a, int[] b) {
        if (a.length == 0 || b.length == 0) {
            return new int[0];
        }

        int n = a.length + b.length - 1;
        int[] result = new int[n];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                result[i + j] += a[i] * b[j];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        PolynomialMultiplication pm = new PolynomialMultiplication();
        int[] a = {2, 1};
        int[] b = {3, 4};
        int[] result = pm.multiply(a, b);
        System.out.println(Arrays.toString(result));
    }
}
