package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        boolean isMoreGame = true;
        // TODO: 프로그램 구현
        while (isMoreGame) {
            List<Integer> playerNumList = getPlayerNumList();
            List<Integer> computerNumList = getComputerNumList();
            Game game = new Game(playerNumList, computerNumList);
            game.start();
            if(game.isSuccess())
                isMoreGame = game.isMoreGame();
        }
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
