package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        boolean restart = true;
        while (restart) {
            System.out.println("<<숫자 야구 게임>>");
            System.out.println("========");
            System.out.println("1. 게임 시작");
            System.out.println("2. 게임 종료");
            System.out.println("========");

            String input = Console.readLine();
            int num = Integer.parseInt(input);
            switch (num) {
                case 1:
                    System.out.println("게임 시작");
                    Computer computer = new Computer();
                    computer.generateNumber();
                    Player player = new Player();
                    boolean correct = false;
                    while (!correct) {
                        player.guessNumber();
                        correct = computer.checkAnswer(player.getNumber());
                    }
                    break;

                case 2:
                    System.out.println("게임 종료");
                    restart = false;
                    break;

                default:
                    System.out.println("올바른 메뉴 번호를 입력하세요");
            }
        }
    }
}
