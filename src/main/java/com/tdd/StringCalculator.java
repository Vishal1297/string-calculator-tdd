package com.tdd;

import java.util.Arrays;

public class StringCalculator {

    public int add(String numbers) {
        int length = numbers.length();
        if (length < 2) {
            if (numbers.isEmpty()) {
                return 0;
            } else {
                return convertToInt(numbers);
            }
        } else {
            String delimiter = ",";
            return sum(splitNumbers(numbers, delimiter + "|\n"));
        }
    }

    private String[] splitNumbers(String numbers, String divider) {
        return numbers.split(divider);
    }

    private int convertToInt(String num) {
        return Integer.parseInt(num);
    }

    private int sum(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(this::convertToInt)
                .sum();
    }
}
