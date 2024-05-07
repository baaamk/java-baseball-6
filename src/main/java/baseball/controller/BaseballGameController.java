
package baseball.controller;

import baseball.model.ComputerNumberModel;
import baseball.model.PlayerNumberModel;
import baseball.model.ValidatorModel;
import baseball.view.BaseballGameView;

public class BaseballGameController {
    private final ComputerNumberModel computer;
    private static PlayerNumberModel player;
    private final ValidatorModel validatorModel;

    public BaseballGameController() {
        computer = new ComputerNumberModel();
        validatorModel = new ValidatorModel();
    }

    public void play() {
        do {
            getNumberFromPlayer();
            printCount(getNumberCompare());
        } while (!isBaseballGameEnd());

    }


    public void getNumberFromPlayer() {
        player = new PlayerNumberModel(BaseballGameView.setUserNumber());
        player.getPlayerNumber();
    }

    public int[] getNumberCompare() {

        return validatorModel.getNumberCompare(player.getPlayerNumber(), computer.getComputerNumber());
    }

    public void printCount(int[] count) {
        printBallCount(count);
        printStrikeCount(count);
        printNothing(count);
    }

    public static void printBallCount(int[] count) {
        if (count[0] != 0) {
            if(count[1] !=0){
                BaseballGameView.printCount(count[0]);
                BaseballGameView.printBallStrikeMessage();;
            }else{
                BaseballGameView.printCount(count[0]);
                BaseballGameView.printBallMessage();
            }

        }
    }

    public static void printStrikeCount(int[] count) {
        if (count[1] != 0) {
            BaseballGameView.printCount(count[1]);
            BaseballGameView.printStrikeMessage();
        }
    }

    public static void printNothing(int[] count) {
        if (count[0] == 0 && count[1] == 0) {
            BaseballGameView.printNothingMessage();
        }
    }


    public boolean isBaseballGameEnd() {
        if (validatorModel.isThreeStrike()) {
            BaseballGameView.printBaseballGameEndMessage();
            return true;
        }
        return false;
    }
}