package baseball.service;

public class InputValidService {
    boolean endGame = false;
    //올바른 입력값이 들어왔는지 확인
    public boolean isInputValid(String str){
        //게임이 안끝났을 경우
        if(!endGame){
            for(int i=0; i<str.length(); i++){
                char target = str.charAt(i);
                if(target < 48 || target > 57){
                    return false;
                }
            }
            return true;
        }

        if(str.charAt(0) == 49 || str.charAt(0) == 50){
            return true;
        }
        return false;
    }

    public void updateStatus(){
        this.endGame = !endGame;
    }

    public boolean continueOrEndGame(String ctn){
        int answer = Integer.parseInt(ctn);
        switch(answer){
            case 1:
                updateStatus();
                return true;
            case 2:
                return false;
        }
        return false;
    }

    public boolean isStrikeAll(){
        return endGame;
    }
}
