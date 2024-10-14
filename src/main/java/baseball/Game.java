package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

import static baseball.ballType.*;


public class Game {

    ArrayList<Integer> computerNums;
    int numSize;

    /**
     * Game 을 시작하는 start() 메서드
     * Application 에서 인스턴스화 하여 이 메서드를 부름으로써 게임을 시작한다.
     */
    public void start() {

        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean isStartGame = true;
        while(isStartGame) {

            computerNums = getComputerNums();

            startRound();

            isStartGame = checkStart();
        }
    }


    /**
     * 라운드 진행 startRound() 메서드
     */
    public void startRound() {

        while(true) {

            System.out.println("숫자를 입력해주세요: ");
            int input = Integer.parseInt(Console.readLine());

            checkException(1, input);

            int strike = 0;
            int ball = 0;
            for(int i =numSize-1; i>=0; i--) {
                int cur = input %10;
                ballType ballType = getStrikeOrBallOrNothing(cur, i);

                if(ballType == STRIKE) {
                    strike++;
                }
                else if(ballType  == BALL) {
                    ball++;
                }

                input /=10;
            }

            if(strike !=0 && ball != 0) {
                System.out.println(ball+"볼 " + strike +"스트라이크");
            }
            else if(strike != 0) {
                System.out.println(strike +"스트라이크");

                if(strike == numSize) {

                    System.out.println("3개의 숫자를 모두 맞추셨습니다! 게임 종료");
                    break;
                }
            }
            else if(ball != 0) {
                System.out.println(ball+"볼");
            }
            else {
                System.out.println("낫싱");
            }

        }

    }



    /**
     *
     * @param input 사용자 입력 숫자 1개
     * @param index 시용자 입력 숫자의 Index
     * @return EnumType ballType 반환
     */
    public ballType getStrikeOrBallOrNothing (int input, int index) {


        for(int i=0; i<numSize; i++) {
            int cur = computerNums.get(i);

            if(input == cur && index == i) {
                return STRIKE;
            }
            else if(input == cur) {
                return BALL;
            }
        }

        return NOTHING;

    }

    /**
     * 게임이 끝난 후, 재시작을 묻는 checkStart() 메서드
     * @return Boolean 형 반환, true => 재시작, false => 종료
     */
    public boolean checkStart() {

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = Integer.parseInt(Console.readLine());

        checkException(2, input);

        return input == 1;
    }

    /**
     * 랜덤 수 3개를 갖는 리스트를 만드는 getComputerNums() 메서드
     * @return 3개의 랜덤 수를 갖는 ArrayList 반환
     */
    public ArrayList<Integer> getComputerNums() {

        ArrayList<Integer> computerNums = new ArrayList<>();

        while(computerNums.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            if(!computerNums.contains(num)) {
                computerNums.add(num);
            }
        }

        numSize = computerNums.size();

        return computerNums;
    }


    /**
     * 사용자 입력 예외를 잡는 checkException() 메서드
     * 1. 게임 시작 및 종료 선택 시, 1 또는 2의 입력이 아닐 때
     * 2. 게임 라운드 진행 시, 3개의 숫자가 아닌, 2개 이하, 4개 이상의 숫자가 입력될 때
     * @param eventType 상황에 따른 eventType
     * @param input 사용자 입력 input
     */
    public void checkException(int eventType, int input) {

        switch (eventType) {
            case 1:
                if(input > 999 || input < 100)
                    throw new IllegalArgumentException();
                break;

            case 2:
                if(input !=1 && input !=2)
                    throw new IllegalArgumentException();
                break;
        }

    }

}
