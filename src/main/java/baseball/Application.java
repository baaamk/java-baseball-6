package baseball;

import baseball.config.AppConfig;
import baseball.controller.GameController;

/**
 * 프로그램 진입점을 담당하는 클래스
 */
public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = AppConfig.getInstance();

        GameController controller = appConfig.GameController();
        controller.run();
    }
}
