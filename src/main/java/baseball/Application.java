package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        boolean isMoreGame = true;
        Computer computer = Computer.computer;
        // TODO: 프로그램 구현
        while (isMoreGame) {
            List<Integer> playerNumList = getPlayerNumList();
            List<Integer> computerNumList = computer.getPickedRandomList();
            Game game = new Game(playerNumList, computerNumList);
            game.start();
            if(game.isSuccess()) {
                isMoreGame = game.isMoreGame();
                computer.setPickedRandomList();
            }
        }
    }

    private static List<Integer> getPlayerNumList() {
        Player player = Player.player;
        player.setInputNumList();
        player.changeToList();
        return player.getInputNumList();
    }
}
