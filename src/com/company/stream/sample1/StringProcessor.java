package com.company.stream.sample1;

@FunctionalInterface
interface StringProcessor {

    static boolean isLowerCase(final String s) {
        boolean result = true;
        for (int i = 0; i < s.length() && result; ++i) {
            result = Character.isLowerCase(s.charAt(i));
        }
        return result;
    }

    static boolean isUpperCase(final String s) {
        boolean result = true;
        for (int i = 0; i < s.length() && result; ++i) {
            result = Character.isUpperCase(s.charAt(i));
        }
        return result;
    }

    String process(final String string);

}
