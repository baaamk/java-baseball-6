package baseball.service;

import java.util.List;

public class Service {
    InputValidService inputValidService = new
            InputValidService();

    public String judgement(String str, List<String> ls){
        int strike = 0;
        int ball = 0;
        for(int i=0; i<3; i++){
            String target = str.substring(i,i+1);
            for(String collect : ls){
                if(target.equals(collect)){
                    if(ls.indexOf(collect) == i){
                        strike +=1;
                    }
                    else{
                        ball +=1;
                    }
                }
            }
        }
        String res = result(strike, ball);
        if(strike == 3){
            strikeAll();
        }
        return res;
    }

    private String result(int strike, int ball){
        String res = "낫싱";
        if(strike > 0){
            res = String.valueOf(strike)+"스트라이크 ";
        }
        else if(ball > 0){
           res += String.valueOf(ball)+"볼 ";
           return res;
        }
        return res;
    }

    private void strikeAll(){
        inputValidService.updateStatus();
    }


}
