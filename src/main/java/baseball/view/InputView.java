package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final String READ_NUMBER_SENTENCE = "숫자를 입력해주세요 : ";

    public String readNumber(){
        System.out.print(READ_NUMBER_SENTENCE);
        return Console.readLine();
    }

    public String readLine(){
        return Console.readLine();
    }
}
