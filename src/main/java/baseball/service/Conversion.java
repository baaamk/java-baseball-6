package baseball.service;

import java.util.ArrayList;
import java.util.List;

public class Conversion {
    public static List<Integer> stringToList(String userNumbers) {
        List<Integer> convertedNumbers = new ArrayList<>();
        for(int i = 0; i < 3; i ++) {
            convertedNumbers.add(userNumbers.charAt(i)-'0');
        }
        return convertedNumbers;
    }
}
