package baseball.domain;

import baseball.exception.ErrorMessage;
import baseball.exception.InputNotNumericException;
import baseball.exception.InputNullOrBlankException;
import baseball.exception.InputNumberOverflowException;
import baseball.util.InputParser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 숫자 야구 게임에 사용되는 숫자 도메인 클래스
 */
public class BaseballNumber {
    public static int NUMBER_SIZE = 3;
    public static int NUMBER_MIN = 1;
    public static int NUMBER_MAX = 9;

    private final List<Integer> numbers;

    public BaseballNumber(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static BaseballNumber from(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (String numberString : input.split("")) {
            try {
                numbers.add(InputParser.parseToInt(numberString));
            } catch (InputNullOrBlankException e) {
                throw new IllegalArgumentException(ErrorMessage.NUMBER_NULL_OR_BLANK.getMessage());
            } catch (InputNotNumericException e) {
                throw new IllegalArgumentException(ErrorMessage.NUMBER_NOT_NUMERIC.getMessage());
            } catch (InputNumberOverflowException e) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_SIZE.getMessage());
            }
        }
        return new BaseballNumber(numbers);
    }

    public List<Match> match(BaseballNumber guess) {
        List<Match> matches = new ArrayList<>();
        for (int i = 0; i < NUMBER_SIZE; i++) {
            int number = numbers.get(i);
            boolean hasMatchingNumber = guess.contains(number);
            boolean hasCorrectMatchIndex = guess.get(i) == number;
            if (hasMatchingNumber) {
                matches.add(Match.of(hasMatchingNumber, hasCorrectMatchIndex));
            }
        }
        return matches;
    }

    private boolean contains(int number) {
        return numbers.contains(number);
    }

    private int get(int index) {
        return numbers.get(index);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplication(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_SIZE.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < NUMBER_MIN || number > NUMBER_MAX) {
                throw new IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE.getMessage());
            }
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(ErrorMessage.NUMBER_DUPLICATED.getMessage());
            }
        }
    }
}
