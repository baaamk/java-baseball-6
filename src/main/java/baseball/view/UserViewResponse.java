package baseball.view;

public class UserViewResponse {

    //(1) 입력한 숫자에 따른 결과 화면 띄우기
    static final public void JUDGEMENT_MESSAGE(String res){
        System.out.println(res);
    }

    //(2) 잘못된 값을 넣은 경우 -> IllegalArgumentException 띄우기
    static final public void EXCEPTION_MESSAGE(){
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    //(3) 모든 숫자를 맞춰 종료하는 화면, 재시작과 게임종료를 알림
    static final public void END_GAME_MESSAGE(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    //(4) 게임 시작 문구 출력 "숫자 야구 게임을 시작합니다"
    static final public void START_GAME_MESSAGE(){
        System.out.print("숫자 야구 게임을 시작합니다.");
    }

}
