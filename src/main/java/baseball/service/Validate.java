package baseball.service;

import java.util.HashSet;
import java.util.Set;

public class Validate {

    public static boolean validator(String userInput) {
        if (userInput == null || userInput.isBlank()) {
            return false;
        } else if (!userInput.matches("\\d+")) {
            return false;
        } else if (userInput.length() != 3) {
            return false;
        } else if (!hasUniqueDigits(userInput)) {
            return false;
        }

        return true;
    }


    public static int commandValidator(String userCommandInput) {
        if(!(userCommandInput.equals("1") || userCommandInput.equals("2"))) {
            throw new IllegalArgumentException("1또는 2를 입력해주세요.");
        }
        else if (userCommandInput.equals("1")) {
            return 1;
        }
        else {
            return 2;
        }
    }

    private static boolean hasUniqueDigits(String userInput) {
        Set<Character> digitSet = new HashSet<>();
        for (char c : userInput.toCharArray()) {
            if (!digitSet.add(c)) {
                return false;
            }
        }
        return true;
    }
}
