package baseball.controller;

import baseball.model.computer.Computer;
import baseball.model.computer.InputValidator;
import baseball.model.computer.RandomNumberGenerator;
import baseball.model.player.Player;
import baseball.view.CommonView;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private final Computer computer;
    private final InputValidator inputValidator;
    private final Player player;
    private final CommonView commonView;
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(Computer computer, InputValidator inputValidator, Player player, CommonView commonView, InputView inputView, OutputView outputView) {
        this.computer = computer;
        this.inputValidator = inputValidator;
        this.player = player;
        this.commonView = commonView;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start(){
        commonView.printStartMessage();
        while (player.getToken()==1){
            computer.makeAnswer();
            playGame();
            player.setToken(inputValidator.validateRestartNumber(inputView.printRestartMessage()));
        }
    }

    public void playGame(){

        while(computer.getScore().getStrike() != RandomNumberGenerator.NUMBER_LENGTH){
            player.setGuess(inputValidator.validateGameNumber(inputView.printInputMessage()));
            computer.validateAnswer(player.getGuess());
            outputView.printScore(computer.getScore());
        }
        computer.getScore().resetScore();
    }
}
