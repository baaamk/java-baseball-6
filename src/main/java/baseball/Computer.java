package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private int[] numbers;

    public Computer(){
        this.numbers = new int[3];
    }

    public void generateNumbers(){
        for (int i = 0; i < 3; i++){
            this.numbers[i] = Randoms.pickNumberInRange(1, 9);
        }
    }

    public void printStartMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public int[] getNumbers(){
        return this.numbers;
    }

}
