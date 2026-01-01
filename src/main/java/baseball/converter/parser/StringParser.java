package baseball.converter.parser;

import baseball.exception.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public class StringParser {

    private static final String NUMBER_REGEX = "^(?!.*(.).*\\1)[1-9]{3}$";
    private static final String RETRY_NUMBER_REGEX = "^[12]$";

    private StringParser() {
    }

    public static List<Integer> parseToList(String inputNumbers) {
        validateInputNumber(inputNumbers);

        return Arrays.stream(inputNumbers.split(""))
                .map(Integer::parseInt)
                .toList();
    }

    public static int parseToInt(String inputRetry) {
        validateRetryNumber(inputRetry);
        return Integer.parseInt(inputRetry);
    }

    private static void validateInputNumber(String inputNumbers) {
        if (!inputNumbers.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DUPLICATE_AND_RANGE_NUMBER.getMessage());
        }
    }

    private static void validateRetryNumber(String inputRetry) {
        if (!inputRetry.matches(RETRY_NUMBER_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RETRY_NUMBER.getMessage());
        }
    }

}
