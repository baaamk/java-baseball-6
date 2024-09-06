package baseball;

import baseball.domain.Computer;
import baseball.domain.Numbers;
import baseball.domain.User;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainController {
    public void run() {
        Computer computerNumbers = gameInit();
        gameProceed(computerNumbers);
        askForRestart(computerNumbers);
    }


    private static void gameProceed(Computer computerNumbers) {
        boolean isCorrect;
        do {
            User userNumbers = new User(readUserNumbers());
            isCorrect = computerNumbers.compareNumbers(userNumbers);
        } while (!isCorrect);


    }


    private static Computer gameInit() {
        Computer computerNumbers = new Computer(Numbers.createRandomNumber());
        System.out.println("숫자 야구 게임을 시작합니다.");
        return computerNumbers;
    }
    private static void askForRestart(Computer computerNumbers) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();

        if (input.equals("1")) {
            computerNumbers.resetNumbers();
            gameProceed(computerNumbers);
        }
        if (input.equals("2")) {
            System.out.println("게임 종료");
        }
    }


    private static Numbers readUserNumbers() {
        System.out.printf("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();

        validateisPositiveInteger(userInput);

        validateStringBlank(userInput);
        validateStringLegnth(userInput);
        validateDuplicatedInput(userInput);

        return readStringToNumbers(userInput);
    }

    private static Numbers readStringToNumbers(String userInput) {
        List<Integer> userNumbers = new ArrayList<>();

        for (int i = 0; i < userInput.length(); i++) {
            int number = Integer.parseInt(String.valueOf(userInput.charAt(i)));
            userNumbers.add(number);
        }
        return new Numbers(userNumbers);
    }

    private static void validateisPositiveInteger(String userInput) {
            // 문자열이 정확히 3자여야 함을 확인
            if (userInput.length() != 3) {
                throw new IllegalArgumentException("입력은 반드시 3개를 초과할수없습니다.");
            }

            // 문자열의 모든 문자가 '1'에서 '9' 사이의 숫자인지 확인
            for (char c : userInput.toCharArray()) {
                if (c < '1' || c > '9') {
                    throw new IllegalArgumentException("문자열은 1부터 9까지의 숫자만 포함해야 합니다.");
                }
            }
        }

    private static void validateDuplicatedInput(String userInput) {
        Set<Character> uniqueChar = new HashSet<>();
        for (int i = 0; i < userInput.length(); i++) {
            char currentChar = userInput.charAt(i);

            if (uniqueChar.contains(currentChar)) {
                throw new IllegalArgumentException("중복된 숫자가 포함되어 있습니다.");
            }
            uniqueChar.add(currentChar);
        }

    }

    private static void validateStringBlank(String userInput) {
        if (userInput.isBlank()) {
            throw new IllegalArgumentException("빈값은 입력할 수 없습니다.");
        }
    }

    private static void validateStringLegnth(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("입력은 반드시 3개의 숫자여야 합니다.");
        }
    }


}
