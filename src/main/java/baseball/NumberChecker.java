package baseball;

public class NumberChecker {
    private int strikeCnt;
    private int ballCnt;

    public NumberChecker(int strikeCnt, int ballCnt) {
        this.strikeCnt = strikeCnt;
        this.ballCnt = ballCnt;
    }

    public int getStrikeCnt() {
        return strikeCnt;
    }

    public int getBallCnt() {
        return ballCnt;
    }
}
