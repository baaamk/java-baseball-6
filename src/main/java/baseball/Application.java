package baseball;

import baseball.controller.GameController;
import baseball.model.computer.Computer;
import baseball.model.computer.InputValidator;
import baseball.model.computer.RandomNumberGenerator;
import baseball.model.computer.Score;
import baseball.model.player.Player;
import baseball.view.CommonView;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;


public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(
                new Computer(new ArrayList<>(),new Score(), new RandomNumberGenerator()),
                new InputValidator(),
                new Player(new ArrayList<>(), 1),
                new CommonView(),
                new InputView(new InputValidator()),
                new OutputView());

        gameController.start();
    }
}
