package baseball;

import baseball.controller.BaseballGameController;
import baseball.model.RetryNumberModel;
import baseball.view.BaseballGameView;

public class Application {
    public static void main(String[] args) {
        BaseballGameView.printBaseballGameStart();
        do {
            BaseballGameController baseballGameController = new BaseballGameController();
            baseballGameController.play();
        } while (askRetry());
    }

    public static boolean askRetry() {
        RetryNumberModel retryNumberModel = new RetryNumberModel(BaseballGameView.setRetryNumber());
        if (retryNumberModel.getRetryNumber().equals("1")) {
            return true;
        }
        return false;
    }
}