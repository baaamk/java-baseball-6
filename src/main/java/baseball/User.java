package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {
    public User() {
    }

    /**
     * 게임 시작
     * @param numbers
     */
    public void startGame(int[] numbers) {

        boolean correct = false;

        System.out.println("숫자 야구 게임을 시작합니다.");

        // correct가 true가 될 때까지 반복
        while(!correct){
            System.out.print("숫자를 입력해주세요 : ");

            // 입력 받기
            String userInput = Console.readLine();
            checkValidInput(userInput);
            correct = checkNumbers(numbers, userInput);
        }

    }


    /**
     * 입력받은 숫자가 유효한지 확인
     * @param userInput
     */
    private void checkValidInput(String userInput) {
        // 입력받은 숫자가 3자리인지 확인
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }

        // 입력받은 숫자가 중복되는지 확인
        if (userInput.charAt(0) == userInput.charAt(1) || userInput.charAt(1) == userInput.charAt(2) || userInput.charAt(0) == userInput.charAt(2)) {
            throw new IllegalArgumentException("중복되지 않는 숫자를 입력해주세요.");
        }

        // 입력받은 숫자가 숫자인지 확인
        try {
            Integer.parseInt(userInput);
        }
        catch (Exception e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }

        int userNumber = Integer.parseInt(userInput);

        while (userNumber != 0) {
            // 최우측 숫자 추출
            int last = userNumber % 10;

            // 1~9 사이의 숫자인지 확인
            if (last <= 0 || 10 <= last) {
                throw new IllegalArgumentException("1 이상, 9 이하의 숫자를 입력해주세요.");
            }

            // 최우측 숫자 삭제
            userNumber /= 10;
        }

    }

    /**
     * 입력받은 숫자가 정답인지 확인
     * @param numbers
     * @param userInput
     * @return
     */
    public boolean checkNumbers(int[] numbers, String userInput) {
        // 입력받은 숫자를 배열로 변환
        int[] userNumbers = new int[3];
        for (int i = 0; i < 3; i++) {
            userNumbers[i] = Integer.parseInt(userInput.substring(i, i + 1));
        }

        // 스트라이크, 볼 개수 초기화
        int strike = 0;
        int ball = 0;

        // 스트라이크, 볼 개수 계산
        for (int i = 0; i < 3; i++) {
            if (numbers[i] == userNumbers[i]) {
                strike++;
            }
            else if (contains(numbers, userNumbers[i])) {
                ball++;
            }
        }

        // 결과 출력

        if (ball > 0) {
            System.out.print(ball + "볼");
            if (strike > 0) {
                System.out.print(" ");
            }
            else {
                System.out.println();
            }
        }

        if (strike > 0) {
            System.out.println(strike + "스트라이크");
        }

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }

        return false;

    }

    /**
     * 배열에 숫자가 포함되어 있는지 확인
     * @param numbers
     * @param userNumber
     * @return
     */
    private boolean contains(int[] numbers, int userNumber) {
        for (int number : numbers) {
            if (number == userNumber) {
                return true;
            }
        }
        return false;
    }

}
