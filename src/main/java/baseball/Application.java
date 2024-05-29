package baseball;

import baseball.controller.BaseBallGame;
import baseball.model.RetryNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        OutputView.printGameStart();
        do {
            BaseBallGame baseballGame = new BaseBallGame();
            baseballGame.start();
        } while (askRetry());
    }

    public static boolean askRetry() {
        RetryNumber retryNumber = new RetryNumber(InputView.setRetryNumber());

        if (retryNumber.getRetryNumber().equals("1")) {
            return true;
        }

        return false;
    }
}