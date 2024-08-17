package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> playerNumList = getPlayerNumList();
        List<Integer> computerNumList = getComputerNumList();
        Game game = new Game(playerNumList, computerNumList);
        game.printGameStart();
        game.playGame();
        game.printResult();
    }

    private static List<Integer> getPlayerNumList() {
        Player player = Player.player;
        player.setInputNumList();
        player.changeToList();
        return player.getInputNumList();
    }

    private static List<Integer> getComputerNumList() {
        Computer computer = Computer.computer;
        computer.setPickedRandomList();
        return computer.getPickedRandomList();
    }
}
