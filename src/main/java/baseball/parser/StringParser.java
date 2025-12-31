package baseball.parser;

import java.util.Arrays;
import java.util.List;

public class StringParser {

    private StringParser(){
    }

    public static List<Integer> parseToInt(String inputNumbers){
        return Arrays.stream(inputNumbers.split(""))
                .map(Integer::parseInt)
                .toList();
    }
}
