package baseball.model.computer;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {

    public Integer validateRestartNumber(String restartNum){

        if( !restartNum.equals("1") && !restartNum.equals("2")) {
            throw new IllegalArgumentException("입력값이 1 또는 2가 아닙니다.");
        }

        return Integer.parseInt(restartNum);
    }

    public List<Integer> validateGameNumber(String gameNumber) {

        if (gameNumber.length() != RandomNumberGenerator.NUMBER_LENGTH ){
            throw  new IllegalArgumentException(String.format("%d 자리가 아닙니다", RandomNumberGenerator.NUMBER_LENGTH));
        }

        List<Integer> number = new ArrayList<>();

        for(int i=0; i<3; i++){
            if(!(gameNumber.charAt(i)>= 49 && gameNumber.charAt(i)<=57)) throw new IllegalArgumentException("1 부터 9 사이 숫자가 아닙니다");
            number.add(Character.getNumericValue(gameNumber.charAt(i)));
        }

        return  number;
    }

}
