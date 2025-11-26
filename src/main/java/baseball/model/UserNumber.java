package baseball.model;

public class UserNumber {

    private final String numbers;

    private UserNumber(String numbers) {
        this.numbers = numbers;
    }

    public static UserNumber of(String numbers) {
        validate(numbers);
        return new UserNumber(numbers);
    }

    private static void validate(String numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("비어있으면 안됩니다.");
        }

        for (char number : numbers.toCharArray()) {
            if (!Character.isDigit(number)) {
                throw new IllegalArgumentException("숫자만 입력 가능합니다.");
            }
        }

        if (numbers.length() != 3) {
            throw new IllegalArgumentException("3자리여야 합니다");
        }
        if (duplicateNumber(numbers)) {
            throw new IllegalArgumentException("숫자는 중복되면 안됩니다.");
        }
    }

    private static boolean duplicateNumber(String numbers) {
        int[] arr = new int[10];

        for (int i = 0; i < numbers.length(); i++) {
            int c = numbers.charAt(i) - '0';
            arr[c]++;
            if (arr[c] != 1) {
                return false;
            }
        }

        return true;
    }
}
