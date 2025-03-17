package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean play = true;
        while (play) {
            playGame();
            play = isRestartGame();
        }
    }

    private static void playGame() {
        List<Integer> computer = getComputer();
        boolean gameWon = false;
        while (!gameWon) {
            List<Integer> me = getNum();

            List<Integer> checked = check(computer, me);
            int ball = checked.get(0), strike = checked.get(1);

            gameWon = printBallStrike(ball, strike);

            System.out.print("\n");
        }
    }

    private static boolean isRestartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int ans = Integer.parseInt(Console.readLine());
        checkAnswer(ans);
        if (ans == 1) {
            return true;
        }
        else {
            return false;
        }
    }

    private static boolean printBallStrike(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }
        if (ball != 3 && strike != 3) {
            if (ball != 0) {
                System.out.printf("%d볼 ", ball);
            }
            if (strike != 0) {
                System.out.printf("%d스트라이크", strike);
            }
        }
        else if (ball == 3) {
            System.out.printf("%d볼", ball);
        }
        else {
            System.out.printf("%d스트라이크\n", strike);
            System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    private static boolean checkNum(String num) {
        if (num.length() != 3) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    continue;
                }
                if (num.charAt(i) == num.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void checkAnswer(int ans) {
        if (ans != 1 && ans != 2) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> getComputer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    private static List<Integer> getNum() {
        System.out.print("숫자를 입력해주세요 : ");
        String num = Console.readLine();
        if (!checkNum(num)) {
            throw new IllegalArgumentException();
        }
        List<Integer> me = new ArrayList<>();
        for (int i = 0; i < num.length(); i++) {
            me.add(Integer.parseInt(num.substring(i, i+1)));
        }
        return me;
    }

    private static List<Integer> check(List<Integer> computer, List<Integer> me) {
        List<Integer> ans = new ArrayList<>(); // strike, ball
        int strike = 0, ball = 0;

        for (int i = 0; i < 3; i++) {
            int m = me.get(i);
            if (computer.get(i).equals(m)) {
                strike++;
            }
            else if (computer.contains(m)) {
                ball++;
            }
        }
        ans.add(ball);
        ans.add(strike);
        return ans;
    }
}
