package com.company.stream.sample1;

public class StringProcessorStreamSamples {

    public static void main(String[] args) {

        final StringProcessor toLowerCase = String::toLowerCase;
        final StringProcessor toUpperCase = String::toUpperCase;

        final String lowerCaseString = toLowerCase.process("LAMBDA");
        System.out.println("String: " + lowerCaseString);
        System.out.println("Is lower case string: " + StringProcessor.isLowerCase(lowerCaseString));

        final String upperCaseString = toUpperCase.process(lowerCaseString);
        System.out.println("String: " + upperCaseString);
        System.out.println("Is upper case string: " + StringProcessor.isUpperCase(upperCaseString));
    }
}
