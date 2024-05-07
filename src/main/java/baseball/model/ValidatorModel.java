package baseball.model;

import baseball.util.NumberCompare;

public class ValidatorModel {
    private final NumberCompare numberCompare;

    public ValidatorModel() {
        numberCompare = new NumberCompare();
    }

    public int[] getNumberCompare(String answerNumber, String playerNumber){

        return numberCompare.getNumberCompareResult(answerNumber, playerNumber);
    }

    public boolean isThreeStrike() {
        if (numberCompare.getStrike() == 3) {
            return true;
        }
        return false;
    }

}