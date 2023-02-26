package com.jlr.roman.translator;

import java.util.Map;

/**
 * Class to translate Base 10 to Roman Numbers
 *
 * Ref : https://dl.orangedox.com/yj7O58NnGcewnpH0bY
 */
public class RomanNumberTranslator {

    /**
     * Roman number to Base 10 number mappings
     */
    private final Map<String, Integer> map = Map.of( "I", 1, "V", 5, "X", 10, "L", 50, "C", 100, "D", 500, "M", 1000);

    /**
     * Main method which gets Base 10 numbers and return Roman Numbers
     * @param number
     * @return
     * @throws IllegalArgumentException
     */
    public String translate(final Integer number) throws IllegalArgumentException{

        String romanNumber = "";

        if (number == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        if (number == 0) {
            throw new IllegalArgumentException("Input cannot be zero");
        }
        if (number < 0) {
            throw new IllegalArgumentException("Input cannot be negative");
        }

        StringBuilder sb = new StringBuilder();

        // get the number as a String, get character array
        String numberStr = String.valueOf(number);
        char[] arr = numberStr.toCharArray();
        if (arr.length == 1 ) {
            romanNumber= getDigitNumber(number, "I", "V", "X");
        }
        if (arr.length == 2 ) {
            sb.append(getDigitNumber(Integer.parseInt(String.valueOf(arr[0])),  "X", "L", "C"));
            sb.append(getDigitNumber(Integer.parseInt(String.valueOf(arr[1])),  "I", "V", "X"));
            romanNumber = sb.toString();
        }
        if (arr.length == 3 ) {
            sb.append(getDigitNumber(Integer.parseInt(String.valueOf(arr[0])),  "C", "D", "M"));
            sb.append(getDigitNumber(Integer.parseInt(String.valueOf(arr[1])),  "X", "L", "C"));
            sb.append(getDigitNumber(Integer.parseInt(String.valueOf(arr[2])),  "I", "V", "X"));

            romanNumber = sb.toString();
        }
        if (arr.length == 4 ) {
            sb.append(getDigitNumber(Integer.parseInt(String.valueOf(arr[0])), "M", "", ""));
            sb.append(getDigitNumber(Integer.parseInt(String.valueOf(arr[1])), "C", "D", "M"));
            sb.append(getDigitNumber(Integer.parseInt(String.valueOf(arr[2])), "X", "L", "C"));
            sb.append(getDigitNumber(Integer.parseInt(String.valueOf(arr[3])), "I", "V", "X"));

            romanNumber = sb.toString();
        }
        if (number > 3000) {
            throw new IllegalArgumentException("Input cannot be greater than 3000");
        }

        return romanNumber;
    }

    /**
     *  Get the Roman value of decimal number
     * @param number
     * @param push
     * @param mid
     * @param top
     * @return
     */
    private String getDigitNumber(final Integer number,
                                  final String push,
                                  final String mid,
                                  final String top) {
        String romanNumber = "";

        if (number == 0) {
            romanNumber = "";
        }

        if (number <= 3) {
            romanNumber = postfix("", number, push);
        }

        if (number == 4) {
            romanNumber = prefix(mid, (5 - number), push);
        }

        if (number == 5) {
            romanNumber = mid;
        }

        if (number >= 6 && number <= 8) {
            romanNumber = postfix(mid, (number - 5), push);
        }

        if (number == 9) {
            romanNumber = prefix(top, (10 - number), push);
        }

        return romanNumber;
    }

    /**
     * Post fix I, II, III, and VI,VII, VIII
     * @param src
     * @param number
     * @param symbol
     * @return
     */
    private String postfix(final String src, final int number, final String symbol){
        StringBuilder sb = new StringBuilder(src);
        for ( int i=1; i <= number; i++){
            sb.append(symbol);
        }
        return sb.toString();
    }

    /**
     *
     * @param src
     * @param number
     * @param symbol
     * @return
     */
    private String prefix(final String src, final int number, final String symbol){
        StringBuilder sb = new StringBuilder("");
        for ( int i=1; i <= number; i++){
            sb.append(symbol);
        }
        sb.append(src);
        return sb.toString();
    }


}
