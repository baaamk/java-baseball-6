package baseball.controller;

import baseball.Valid;
import baseball.service.BaseBallGameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BaseBallGameService baseBallGameService;
    private boolean gameFlag;

    public BaseBallController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.baseBallGameService = new BaseBallGameService();
        this.gameFlag = true;
    }

    public void gameStart(){

        outputView.gameStartComment();

        while (gameFlag){
            baseBallGameService.gameSetting();
            readNumberLoop();
            gameRestartCheck();
        }
    }

    private void readNumberLoop(){
        while (true){
            String read = inputView.readNumber();
            Valid.checkNumber(read); // 입력 숫자 검증.
            String matchingValue = baseBallGameService.numberMatching(read);
            outputView.matchingComment(matchingValue);
            if(matchingValue.startsWith("3스트라이크")) {
                break;
            }
        }
    }

    private void gameRestartCheck(){
        outputView.gameReStartComment();
        String read = inputView.readLine();
        if(read.equals("2")){
            gameFlag = false;
        }
    }
}
