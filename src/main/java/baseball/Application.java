package baseball;

import baseball.controller.UserViewController;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        UserViewController userViewController = new UserViewController();
        userViewController.start();
        String str = Console.readLine();
        userViewController.userInput(str);
    }
}
