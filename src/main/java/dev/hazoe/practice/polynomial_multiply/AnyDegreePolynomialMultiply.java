package dev.hazoe.practice.polynomial_multiply;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnyDegreePolynomialMultiply {


    public static String multiply(String input) {
        Pattern pattern = Pattern.compile("\\(([^)]+)\\)\\(([^)]+)\\)");
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid input");
        }

        Map<Integer, Integer> poly1 = parsePolynomial(matcher.group(1));
        Map<Integer, Integer> poly2 = parsePolynomial(matcher.group(2));

        Map<Integer, Integer> result = multiplyPoly(poly1, poly2);

        return polynomialToString(result);
    }

    private static String polynomialToString(Map<Integer, Integer> poly) {
        StringBuilder sb = new StringBuilder();

        List<Integer> powers = new ArrayList<>(poly.keySet());

        powers.sort(Collections.reverseOrder());

        for (int power : powers) {

            int coefficient = poly.get(power);
            if (coefficient == 0) {
                continue;
            }

            if (!sb.isEmpty() && coefficient > 1) {
                sb.append("+");
            }

            if (power == 0) {
                sb.append(coefficient);
            } else if (power == 1) {
                sb.append(coefficient).append("x");
            } else {
                sb.append(coefficient).append("x^").append(power);
            }
        }

        return sb.toString();
    }

    private static Map<Integer, Integer> multiplyPoly(Map<Integer, Integer> poly1, Map<Integer, Integer> poly2) {
        Map<Integer, Integer> result = new HashMap<>();

        for (var term1 : poly1.entrySet()) {
            for (var term2 : poly2.entrySet()) {
                int coefficient = term1.getValue() * term2.getValue();
                int power = term1.getKey() + term2.getKey();

                result.put(power, result.getOrDefault(power, 0) + coefficient);
            }
        }

        return result;
    }

    private static Map<Integer, Integer> parsePolynomial(String poly) {
        Map<Integer, Integer> map = new HashMap<>();

        poly = poly.replace("-", "+-");
        String[] terms = poly.split("\\+");

        for (String term : terms) {
            if (term.isEmpty()) {
                continue;
            }

            int coefficient = 0;
            int power = 0;

            if (term.contains("x")) {

                //coefficient
                coefficient = getCoefficient(term);

                //power
                power = getPower(term);

            } else {
                coefficient = Integer.parseInt(term);
                power = 0;
            }

            map.put(power, map.getOrDefault(power, 0) + coefficient);

        }

        return map;
    }

    private static int getPower(String term) {
        int power;
        if (term.contains("^")) {
            power = Integer.parseInt(term.split("\\^")[1]);
        } else {
            power = 1;
        }
        return power;
    }

    private static int getCoefficient(String term) {
        String[] parts = term.split("x");
        int coefficient;
        if (parts.length == 0 || parts[0].isEmpty()) {
            coefficient = 1;
        } else if (parts[0].equals("-")) {
            coefficient = -1;
        } else {
            coefficient = Integer.parseInt(parts[0]);
        }
        return coefficient;
    }

    public static void main(String[] args) {
        String result = AnyDegreePolynomialMultiply
                .multiply("(2x^2+3x+1)(x^2+4)");
        System.out.println(result);
    }
}
