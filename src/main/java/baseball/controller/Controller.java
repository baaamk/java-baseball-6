package baseball.controller;

import baseball.controller.dto.ResultMapper;
import baseball.model.domain.BaseballNumbers;
import baseball.model.domain.ComputerNumberGenerator;
import baseball.model.domain.Result;
import baseball.service.Service;
import baseball.view.parser.StringParser;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private final Service service;

    public Controller(InputView inputView, OutputView outputView, Service service) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.service = service;
    }

    public void execute(){
        outputView.printStartNotice();
        while (true){
            BaseballNumbers baseballNumbers = BaseballNumbers.of(ComputerNumberGenerator.generateNumber());
            playBaseball(baseballNumbers);
            outputView.printRetryInformation();
            int retryNumber = StringParser.parseToInt(inputView.inputRetry());
            if (retryNumber == 2){
                break;
            }
        }
    }

    private void playBaseball(BaseballNumbers baseballNumbers) {
        while(true){
            outputView.printInputNotice();
            String inputNumbers = inputView.inputNumber();
            List<Integer> parsedInputNumbers = StringParser.parseToList(inputNumbers);
            Result result = service.showResult(baseballNumbers, parsedInputNumbers);
            ResultMapper mappedResult = ResultMapper.from(result);
            outputView.printResult(mappedResult);
            if (result.hasThreeStrike()) {
                break;
            }
        }
        outputView.printFinalInformation();
    }
}
