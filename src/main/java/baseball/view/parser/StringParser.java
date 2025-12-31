package baseball.view.parser;

import java.util.Arrays;
import java.util.List;

public class StringParser {

    private StringParser(){
    }

    public static List<Integer> parseToList(String inputNumbers){
        return Arrays.stream(inputNumbers.split(""))
                .map(Integer::parseInt)
                .toList();
    }

    public static int parseToInt(String inputRetry) {
        return Integer.parseInt(inputRetry);
    }
}
