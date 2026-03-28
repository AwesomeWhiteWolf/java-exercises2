package com.example;
import java.util.*;
import java.util.regex.*;

public class RegexUtils {
    public static boolean isValidEmail(String email) {
        if (email == null) return false;
        return Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$").matcher(email).matches();
    }
    public static List<String> extractDigits(String input) {
        List<String> matches = new ArrayList<>();
        if (input == null) return matches;
        Matcher m = Pattern.compile("\\d+").matcher(input);
        while (m.find()) matches.add(m.group());
        return matches;
    }
}
