package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        backtracking(digits, result, "", 0);
        for (String s: result) {
            System.out.println(s);
        }
        return result;
    }

    private void backtracking(String digits, List<String> result, String tmp, int index) {
        if(index == digits.length()){
            result.add(tmp);
            return;
        }
        char[] possibleChar = getPossibleChar(digits.charAt(index));
        for(int i = 0 ; i < possibleChar.length; i++){
            tmp=tmp+possibleChar[i];
            backtracking(digits, result, tmp, index+1);
            tmp = tmp.substring(0, tmp.length()-1);
        }
    }

    private char[] getPossibleChar(char charAt) {
        switch(charAt){
            case '2':
                return new char[]{'A','B','C'};
            case '3':
                return new char[]{'D','E','F'};
            case '4':
                return new char[]{'G','H','I'};
            case '5':
                return new char[]{'J','K','L'};
            case '6':
                return new char[]{'M','N','O'};
            case '7':
                return new char[]{'P','Q','R','S'};
            case '8':
                return new char[]{'T','U','V'};
            case '9':
                return new char[]{'W','X','Y','Z'};
            default:
                return new char[]{};
        }
    }

    public static void main(String[] args) {
        PhoneNumber p = new PhoneNumber();
        p.letterCombinations("2");
    }

}
