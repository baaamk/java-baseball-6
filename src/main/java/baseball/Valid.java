package baseball;

public class Valid {

    public static void checkNumber(String str) throws IllegalArgumentException{
        if(str.length() != 3){
            throw new IllegalArgumentException();
        }
    }

}
