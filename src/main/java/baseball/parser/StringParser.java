package baseball.parser;

import java.util.Arrays;
import java.util.List;

public class StringParser {
    public List<Integer> parseToInt(String inputNumbers){
        return Arrays.stream(inputNumbers.split(""))
                .map(Integer::parseInt)
                .toList();
    }
}
