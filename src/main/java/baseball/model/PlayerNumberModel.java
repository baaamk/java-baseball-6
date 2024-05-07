package baseball.model;


public class PlayerNumberModel {
    private String playerNumber;

    public PlayerNumberModel(String playerNumber) {

        isStringLengthCorrect(playerNumber);
        isDigitPlayerNumber(playerNumber);
        isDifferentPlayerNumber(playerNumber);

        this.playerNumber = playerNumber;

    }

    public String getPlayerNumber() {

        return playerNumber;
    }

    public static void isStringLengthCorrect(String word) throws IllegalArgumentException {
        if (word.length() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(입력값 3자리수)");
        }
    }

    public static void isDifferentPlayerNumber(String word) throws IllegalArgumentException {
        long uniqueCount = word.chars().distinct().count();
        if (uniqueCount != word.length()) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(중복된 숫자)");
        }
    }

    public static void isDigitPlayerNumber(String word) {
        for (int i = 0; i < word.length(); i++) {
            isDigitCharInString(word, i);
        }
    }

    public static void isDigitCharInString(String word, int index) throws IllegalArgumentException {
        if (!Character.isDigit(word.charAt(index))) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(3자리 자연수가 아닙니다.)");
        }
    }

}