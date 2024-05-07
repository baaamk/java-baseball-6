package baseball.model;

public class RetryNumberModel {
    private String retryNumber;

    public String getRetryNumber(){

        return retryNumber;
    }

    public RetryNumberModel(String retryNumber) {
        isCorrectRetryNumber(retryNumber);
        this.retryNumber = retryNumber;
    }

    public static void isCorrectRetryNumber(String number) throws IllegalArgumentException {
        if (!number.equals("1") && !number.equals("2")) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }
}