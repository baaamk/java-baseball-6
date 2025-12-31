package baseball.controller;

import baseball.view.InputView;
import baseball.view.OutputView;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void execute(){
        outputView.printStartNotice();
    }
}
