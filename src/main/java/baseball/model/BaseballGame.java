package baseball.model;

import baseball.Valid;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    public List<Integer> computerNumber;

    // 랜덤 숫자 생성.
    public void createRandomNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        computerNumber = computer;
        System.out.println(computer);
    }

    // 숫자 매칭
    public String matchNumber(String str){

        int[] checkList  = new int[2];

        List<Integer> readNumber = parsingReadNumber(str);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (computerNumber.get(i).equals(readNumber.get(j))){
                    if(i == j){
                        checkList[0]++; // 스트라이크 count ++
                        continue;
                    }
                    checkList[1]++; // 볼 count ++
                }
            }
        }
        return gameResults(checkList);
    }

    // 사용자 입력 숫자 파싱.
    private List<Integer> parsingReadNumber(String str){
        List<Integer> result = new ArrayList<>();
        int num = Integer.parseInt(str);

        result.add(num / 100);
        num %= 100;
        result.add(num / 10);
        num %= 10;
        result.add(num);

        return result;
    }

    // 게임 결과 문자열 조합.
    private String gameResults(int[] checkList){
        StringBuilder builder = new StringBuilder();

        if(checkList[0] == 3){
            return builder.append("3스트라이크").toString();
        }

        if(checkList[0] == 0 && checkList[1] == 0){
            return builder.append("낫싱").toString();
        }

        if(checkList[1] > 0){
            builder.append(checkList[1]).append("볼 ");
        }

        if(checkList[0] > 0){
            builder.append(checkList[0]).append("스트라이크");
        }

        return builder.toString();
    }
}
