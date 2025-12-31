package baseball.config;

import baseball.controller.Controller;
import baseball.view.InputView;
import baseball.view.OutputView;

public class AppConfig {
    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }

    public Controller controller(){
        return new Controller(inputView(), outputView());
    }
}
