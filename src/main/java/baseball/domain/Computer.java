package baseball.domain;

import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Computer {

    private static Numbers computerNumbers;

    public Computer(Numbers computerNumbers) {
        Computer.computerNumbers = computerNumbers;
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers.getNumbers();
    }

    public static boolean compareNumbers(User userNumbers) {
        List<Integer> computerNumberList = computerNumbers.getNumbers();
        List<Integer> userNumberList = userNumbers.getUserNumbers();

        int strikes = 0;
        int balls = 0;
        boolean result = false;

        //스트라이크, 볼 체크로직
        for (int i = 0; i < userNumberList.size(); i++) {
            int userNumber = userNumberList.get(i);

            if (computerNumberList.contains(userNumber) && computerNumberList.indexOf(userNumber) != i) {
                balls++; // 값은 일치하지만 위치가 다르면 볼
            }
            if (userNumberList.get(i) == computerNumberList.get(i)) {
                strikes++; // 값과 위치가 모두 일치하면 스트라이크
            }
        }
        if (strikes == 3){
            result = true;
        }
        OutputView.printGameResult(strikes,balls);
        return  result;
    }

    public void resetNumbers() {
        computerNumbers =Numbers.createRandomNumber();
    }
}
