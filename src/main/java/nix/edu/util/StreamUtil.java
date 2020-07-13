package nix.edu.util;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.function.UnaryOperator;
import java.util.stream.*;


public class StreamUtil {

    public static void findArrayMaxElement(double[] array) {
        DoubleStream stream = DoubleStream.of(array);
        OptionalDouble maxElement = stream.max();
        if (maxElement.isPresent()) {
            System.out.println("Array max element = " + maxElement.getAsDouble());
        } else {
            System.out.println("No value");
        }
    }

    public static void findArrayMinElement(double[] array) {
        DoubleStream stream = DoubleStream.of(array);
        OptionalDouble minElement = stream.min();
        if (minElement.isPresent()) {
            System.out.println("Array min element = " + minElement.getAsDouble());
        } else {
            System.out.println("No value");
        }
    }

    public static void findArrayAverage(double[] array) {
        DoubleStream stream = DoubleStream.of(array);
        OptionalDouble average = stream.average();
        if (average.isPresent()) {
            System.out.println("Array average = " + average.getAsDouble());
        } else {
            System.out.println("No value");
        }
    }

    public static void findArraySum(double[] array) {
        DoubleStream stream = DoubleStream.of(array);
        double sum = stream.sum();
        System.out.println("Array sum = " + sum);
    }

    public static void findLeapYears(List<Year> list) {
        List<Year> leapYears = list.stream()
                .filter(i -> i.isLeap())
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Leap years: " + leapYears);
    }

    public static void extractSubstringByRegex(List<String> list) {
        List<String> strings = list.stream()
                .map((s) -> s.replaceAll("[0-9]", ""))
                .collect(Collectors.toList());
        System.out.println(strings);
    }

    public static void isPalindromeInList(List<String> list) {
        List<String> strings = list.stream()
                .map((s) -> s.replaceAll("\\s+", "")
                        .toLowerCase()).collect(Collectors.toList());
        List<Boolean> isPalindromesList = strings.stream().map((s) -> IntStream.range(0, s.length() / 2)
                .noneMatch(i -> s.charAt(i) != s.charAt(s.length() - i - 1))).collect(Collectors.toList());
        System.out.println("Check if strings in list are palindromes: " + isPalindromesList);

    }

    public static boolean isPalindrome(String str) {
        String tempString = str.replaceAll("\\s+", "").toLowerCase();
        return IntStream.range(0, tempString.length() / 2)
                .noneMatch(i -> tempString.charAt(i) != tempString.charAt(tempString.length() - i - 1));
    }

    public static void returnIfPalindrome(List<String> list) {
        List<String> palindromes = list.stream()
                .filter(s -> isPalindrome(s) == true)
                .collect(Collectors.toList());
        System.out.println("Palindromes: " + palindromes);
    }

    public static void generatePrimeSequence(long N) {
        Stream primesStream = Stream.iterate(BigInteger.TWO, i -> i.add(BigInteger.ONE))
                .filter(i -> i.isProbablePrime((int)(1-Math.pow(2,-100))));
        List<BigInteger> primes = (List<BigInteger>) primesStream.limit(N).collect(Collectors.toList());
        System.out.println("Prime numbers: " + primes);
    }

    public static void countNumberOfBirthPerMonth(List<LocalDate> list) {
        Map<Month, Integer> mapOfBirthdaysPerMonth = list.stream()
                .map(i -> i.getMonth())
                .collect(Collectors.groupingBy(i -> i, Collectors.reducing(0, e -> 1, Integer::sum)));
        System.out.println("Number of birthdays in each month: " + mapOfBirthdaysPerMonth);
    }

    public static void splitArrayIntoEvenAndOdd(int[] array) {
        int[] evenNumbers = Arrays.stream(array)
                .filter(i -> i % 2 == 0).sorted().toArray();
        int[] oddNumbers = Arrays.stream(array)
                .filter(i -> i % 2 != 0).sorted().toArray();
        System.out.println("Even numbers: " + Arrays.toString(evenNumbers));
        System.out.println("Odd numbers: " + Arrays.toString(oddNumbers));
    }

    public static void applyAllUnaryOperators(List<UnaryOperator<String>> list, String str) {
        UnaryOperator<String> combinedOperator = list.stream()
                .reduce(s -> s, (a, b) -> s -> b.apply(a.apply(s)));
        System.out.println("Combine applying of operators: " + combinedOperator.apply(str));
    }
}
