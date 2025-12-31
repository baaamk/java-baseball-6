package baseball;

import baseball.config.AppConfig;
import baseball.controller.Controller;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        Controller controller = appConfig.controller();

        controller.execute();
    }
}
