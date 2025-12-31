package baseball.config;

import baseball.controller.Controller;
import baseball.service.Service;
import baseball.view.InputView;
import baseball.view.OutputView;

public class AppConfig {

    public Controller controller(){
        return new Controller(inputView(), outputView(), service());
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private Service service() {
        return new Service();
    }


}
