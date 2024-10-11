package baseball.model.player;

import java.util.List;

public class Player {

    private List<Integer> guess;
    private int token;

    public Player(List<Integer> guess, int token) {
        this.guess = guess;
        this.token = token;
    }

    public void setGuess(List<Integer> newGuess){
        guess = newGuess;
    }

    public void setToken(int newToken){
        token=newToken;
    }

    public int getToken() {
        return token;
    }

    public List<Integer> getGuess() {
        return guess;
    }
}
