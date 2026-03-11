package dev.hazoe.practice.polynomial_multiply;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdvancedPolynomialMultiply {

    /*
    There are only 2 expressions
    form (ax+b)(cx+d)
   */
    public String multiply(String input) {
        Pattern pattern = Pattern.compile("\\(([^)]+)\\)\\(([^)]+)\\)");
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid format");
        }

        String p1 = matcher.group(1);
        String p2 = matcher.group(2);

        int[] poly1 = parsePolynomial(p1);
        int[] poly2 = parsePolynomial(p2);

        int[] result = multiplyPoly(poly1, poly2);

        return polynomialToString(result);
    }

    private String polynomialToString(int[] poly) {
        StringBuilder sb = new StringBuilder();
        int degree = poly.length - 1;

        for (int i = 0; i < poly.length; i++) {
            int coef = poly[i];
            int power = degree - i;
            if (coef == 0) {
                continue;
            }

            if (!sb.isEmpty() && coef > 0) {
                sb.append("+");
            }

            if (power == 0) {
                sb.append(coef);
            } else if (power == 1) {
                sb.append(coef).append("x");
            } else {
                sb.append(coef).append("x^").append(power);
            }
        }
        return sb.toString();
    }

    private int[] multiplyPoly(int[] poly1, int[] poly2) {
        int[] result = new int[poly1.length + poly2.length - 1];
        for (int i = 0; i < poly1.length; i++) {
            for (int j = 0; j < poly2.length; j++) {
                result[i + j] += poly1[i] * poly2[j];
            }
        }
        return result;
    }

    private int[] parsePolynomial(String poly) {
        poly = poly.replace("-", "+-");
        String[] terms = poly.split("\\+");

        int a = 0;
        int b = 0;

        for (String term : terms) {
            if (term.isEmpty()) {
                continue;
            }
            if (term.contains("x")) {
                String coefficient = term.replace("x", "");
                if (coefficient.equals("") || coefficient.equals("+")) {
                    a += 1;
                } else if (coefficient.equals("-")) {
                    a -= 1;
                } else {
                    a += Integer.parseInt(coefficient);
                }

            } else {
                b += Integer.parseInt(term);
            }
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        AdvancedPolynomialMultiply pm = new AdvancedPolynomialMultiply();
        System.out.println(pm.multiply("(2x+1)(3x+4)"));
    }

}
