package com.pluralsight.calcengine;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double[] leftVals = {100.0d, 25.0d, 225.0d, 11.0d};
        double[] rightVals = {50.0d, 92.0d, 17.0d, 3.0d};
        char[] opCodes = {'d', 'a', 's', 'm'};
        double[] results = new double[opCodes.length];
        //leftVals, rightVals, opcodes, results known as parallel arrays
	    /*double value1 = 100.0d;
        double value2 = 4.0d;
        double result = 0.0d;
        char opCode = 'd';*/
        if (args.length == 0) {
            for (int i = 0; i < opCodes.length; i++) {
                results[i] = execute(opCodes[i], leftVals[i], rightVals[i]);
            }
            for (double currentResult : results)
                System.out.println(currentResult);
        } else if (args.length == 1 && args[0].equals("interactive"))
            executeInteractively();
        else if (args.length == 3)
            handleCommandLine(args);
        else
            System.out.println("Please provide an operation code and 2 numeric values");

//        if(opCode == 'a')
//            result = value1 + value2;
//        else if (opCode == 's')
//            result = value1 - value2;
//        else if (opCode == 'm')
//            result = value1 * value2;
//        else if (opCode == 'd') {
//            if (value2 != 0)
//                result = value1 / value2;
//        }
//        else {
//            System.out.println("Invalid opCode: "+ opCode);
//            result = 0.0d;
//        }


//        System.out.println("-------logical operators");

        // & --> ture & true, | ---> OR, ^ ---> exclusive or,
        // if one side or the other is true, but not both;
        // ! ---> negation; false

//        boolean done = false;
//        if (! done);
        // And &&, Or ||

        /*System.out.println("--------while loops examples");

        int someValue = 4;
        int factorial = 1;

        while (someValue > 1) {
            factorial *= someValue;
            someValue--;
        }
        System.out.println(factorial);

        System.out.println("-------Do-while Loops");
        int iVal = 5;
        do {
            System.out.print(iVal);
            System.out.print(" *2 =");

            iVal *=2;
            System.out.println((iVal));


        } while (iVal < 25);

        System.out.println("--------For loops");
        for (int i = 1; i < 100; i*=2 )
            System.out.println(i);

        System.out.println("-------arrays");
//        float[] theVals = new float[3];
//        theVals[0] = 10.0f;
//        theVals[1] = 20.0f;
//        theVals[2] = 15.0f;
        float[] theVals = { 10.0f, 20.0f, 15.0f };

        float sum = 0.0f;
        for( int index = 0; index < theVals.length; index++)
            sum += theVals[index];
        System.out.println(sum);*/

    }

    static void executeInteractively() {
        System.out.println("Enter an operation and two numbers:");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split(" ");
        performOperation(parts);
    }

    private static void performOperation(String[] parts) {
        char opCode = opCodeFromString(parts[0]);
        double leftVal = valueFromWord(parts[1]);
        double rightVal = valueFromWord(parts[2]);
        double result = execute(opCode, leftVal, rightVal);
        displayResult(opCode, leftVal, rightVal, result);
    }

    private static void displayResult(char opCode, double leftVal, double rightVal, double result) {
        char symbol = symbolFromOpCode(opCode);
        StringBuilder builder = new StringBuilder(20);
        builder.append(leftVal);
        builder.append(" ");
        builder.append(symbol);
        builder.append(" ");
        builder.append(rightVal);
        builder.append(" = ");
        builder.append(result);
        String output = builder.toString();
        System.out.println(output);
    }

    private static char symbolFromOpCode(char opCode){
        char [] opCodes = {'a', 's', 'm', 'd'};
        char [] symbols = {'+', '-', '*', '/'};
        char symbol = ' ';
        for (int index = 0; index < opCodes.length; index++){
            if(opCode == opCodes[index]){
                symbol = symbols[index];
                break;
            }
        }
        return symbol;
    }

    private static void handleCommandLine(String[] args) {
        char opCode = args[0].charAt(0);
        double leftVal = Double.parseDouble(args[1]);
        double rightVal = Double.parseDouble(args[2]);
        double result = execute(opCode, leftVal, rightVal);
        System.out.println(result);
    }

    static double execute(char opCode, double leftVal, double rightVal) {
        double result;
        switch (opCode) {
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            case 'd':
                result = leftVal != 0 ? rightVal / leftVal : 0.0d;
                break;
            default:
                System.out.println("Invalid opCode: " + opCode);
                result = 0.0d;
                break;
        }
        return result;
    }

    static char opCodeFromString(String operationName) {
        char opCode = operationName.charAt(0);
        return opCode;
    }

    static double valueFromWord(String word) {
        String[] numberWords = {
                "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"
        };
        double value = 0d;
        for (int index = 0; index < numberWords.length; index++) {
            if (word.equals(numberWords[index])) {
                value = index;
                break;
            }
        }
        return value;
    }





}




/* Check 2 strings for equality
 * s1.equals(s2).... do not do s1 == s2 or
 * s3 = s1.intern();
 * s4 = s2.intern();
 * s3 == s4;
 * String Class Methods
 *   length, concat, replace, toLowerCase, toUpperCase, trim, split, charAt, substring
 *   contains, endsWith, startsWith, indexOf, lastIndexOf
 *   equals, equalsIgnoreCase, isEmpty, compareTo, compareToIgnoreCase
 *   format
 *   valueOf
 * */

/*
* String Builder
* String location = "Florida";
* int flightNumber = 175;
* StringBuilder sb = new StringBuilder(40);
* sb.append("I flew to ");
* sb.append(location);
* sb.append(" on Flight #");
* sb.append(flightNumber);
* String message = sb.toString(); "I Flew to Florida on Flight #175"
* */

/* string formatting
* */
