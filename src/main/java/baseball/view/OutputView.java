package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class OutputView {

    private final String GAME_START_SENTENCE= "숫자 야구 게임을 시작 합니다.";
    private final String GAME_END_SENTENCE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void gameStartComment(){
        System.out.println(GAME_START_SENTENCE);
    }

    public void matchingComment(String str){
        System.out.println(str);
    }

    public void gameReStartComment(){
        System.out.println(GAME_END_SENTENCE);
    }


}
