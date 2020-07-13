package nix.edu;

import nix.edu.util.StreamUtil;

import java.time.LocalDate;
import java.time.Year;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;


public class Main {

    static long numberOfGeneratedNumeric = 50;

    static double[] doubles = {1.0, 5.0, 7.0, 5.5, 8.0, 9.5, 2.0, 3.0, 7.8, 8.2};

    static List<Year> listOfYears = Arrays.asList(Year.of(2007), Year.of(2000), Year.of(2017), Year.of(2010),
            Year.of(2004), Year.of(2019), Year.of(2008), Year.of(2012), Year.of(2015), Year.of(2016), Year.of(2020));

    static List<String> stringsRegexExtract = Arrays.asList("some3 string5", "some547 string5", "1so32me string8");

    static List<String> stringsForPalindromes = Arrays.asList("Was it a car    or a cat I saw ",
            "    Some men interpret    nine memos", "Life is a journey", "Pull up if    I pull up", "Now or never");

    static List<LocalDate> birthdays = Arrays.asList(LocalDate.of(1995, 12, 1),
            LocalDate.of(1999, 12, 15),
            LocalDate.of(2000, 05, 30),
            LocalDate.of(1996, 12, 20),
            LocalDate.of(1998, 04, 03),
            LocalDate.of(1993, 04, 23),
            LocalDate.of(2000, 03, 25),
            LocalDate.of(1989, 04, 06));

    static int[] evenAndOddArray = {5, 7, 1, 9, 12, 4, 6, 18, 22, 16, 81, 2, 17};

    static List<UnaryOperator<String>> unaryOperatorList = Arrays.asList(s -> s.toUpperCase(),
            s -> "[" + s + "]",
            s -> s + s);

    static String stringForUnary = "java";

    public static void main(String[] args) {
        System.out.println("-------------- TASK 1 --------------");
        StreamUtil.findArrayMaxElement(doubles);
        StreamUtil.findArrayMinElement(doubles);
        StreamUtil.findArrayAverage(doubles);
        StreamUtil.findArraySum(doubles);
        System.out.println("-------------- TASK 2 --------------");
        StreamUtil.findLeapYears(listOfYears);
        System.out.println("-------------- TASK 3 --------------");
        StreamUtil.extractSubstringByRegex(stringsRegexExtract);
        System.out.println("-------------- TASK 4 --------------");
        StreamUtil.isPalindromeInList(stringsForPalindromes);
        StreamUtil.returnIfPalindrome(stringsForPalindromes);
        System.out.println("-------------- TASK 5 --------------");
        StreamUtil.generatePrimeSequence(numberOfGeneratedNumeric);
        System.out.println("-------------- TASK 6 --------------");
        StreamUtil.countNumberOfBirthPerMonth(birthdays);
        System.out.println("-------------- TASK 7 --------------");
        StreamUtil.splitArrayIntoEvenAndOdd(evenAndOddArray);
        System.out.println("-------------- TASK 8 --------------");
        StreamUtil.applyAllUnaryOperators(unaryOperatorList, stringForUnary);
    }
}
