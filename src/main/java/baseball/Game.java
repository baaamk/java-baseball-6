package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Game {
    public Game() {
    }

    /**
     * 게임 시작
     */
    public void startGame(){
        while (true) {
            Computer computer = new Computer();
            computer.generateNumbers();
            System.out.println(Arrays.toString(computer.getNumbers()));

            User user = new User();
            user.startGame(computer.getNumbers());

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String restart = Console.readLine();

            if (!restart.equals("1")) {
                break;
            }

        }
    }


}
