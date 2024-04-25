package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public List<Integer> inputNumbers() {

        System.out.print("숫자를 입력해주세요 : ");

        String inputNumber = readLine();
        // 입력된 값이 숫자로 변환 가능한지 확인
        try {
            Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해주세요.");
        }

        // 입력된 숫자 중복 확인
        Set<Integer> nonDuplicatedNumbers = new HashSet<>();
        for (char number : inputNumber.toCharArray()) {
            if (!Character.isDigit(number)) {
                throw new IllegalArgumentException("숫자만 입력해주세요.");
            }
            nonDuplicatedNumbers.add(Character.getNumericValue(number));
        }

        // 중복된 숫자가 없고 3개의 숫자인지 확인
        if (nonDuplicatedNumbers.size() != 3) {
            throw new IllegalArgumentException("3개의 중복되지 않는 숫자를 입력해주세요.");
        }

        return new ArrayList<>(nonDuplicatedNumbers);
    }


    //역할: 사용자로 부터 게임을 새로 시작하려면 1, 종료하려면 2를 입력받는 기능 구현
    public int selectNewGameOrQuitGame() {
        System.out.println();
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputNumber = readLine();
        try {
            int number = Integer.parseInt(inputNumber);
            if(number != 1 && number != 2) {
                throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해주세요.");
        }
//        //정수값으로 반환
//        int number = Integer.parseInt(inputNumber);
//        return number;
    }
}
