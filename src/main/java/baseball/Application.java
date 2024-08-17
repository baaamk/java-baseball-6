package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static List<Integer> getPlayerNumList() {
        Player player = Player.player;
        player.setInputNumList();
        player.changeToList();
        return player.getInputNumList();
    }
}
