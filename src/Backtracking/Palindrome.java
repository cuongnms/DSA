package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Palindrome {
    public List<List<String>> partition(String s) {
        if(s== null || s.length() == 0){
            return new ArrayList<>();
        }
        List<List<String>> result = new ArrayList<>();
        backtracking(result, new ArrayList<>(), 0, s, "");
        for(List<String> list: result){
            System.out.println(Arrays.toString(list.toArray()));
        }
        return result;
    }

    private void backtracking(List<List<String>> result, ArrayList<String> tmp, int index, String s, String tmpString) {
        if(index == s.length()){
            result.add(tmp);
            return;
        }
        String stmp = tmpString;
        for(int i = index; i < s.length(); i++ ){
            if(i > index && s.charAt(i) == s.charAt(i-1)){
                continue;
            }
            stmp = stmp + s.charAt(i);
            if(isPalindrome(stmp)){
                tmp.add(stmp);
            }
            backtracking(result, tmp, i+1, s, stmp);

        }
    }

    private boolean isPalindrome(String s){
        if(s.length()==1){
            return true;
        }
        for(int i = 0 ; i < s.length()/2 ; i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Palindrome p = new Palindrome();
//        System.out.println(p.isPalindrome("a"));
        p.partition("aab");
    }

}
