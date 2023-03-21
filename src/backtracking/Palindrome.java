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
        backtracking(result, new ArrayList<>(), 0, s);
        for(List<String> list: result){
            System.out.println(Arrays.toString(list.toArray()));
        }
        return result;
    }

    private void backtracking(List<List<String>> result, ArrayList<String> tmp, int index, String s) {
        if(index == s.length()){
            result.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = index; i < s.length(); i++ ){
            if(isPalindrome(s.substring(index, i+1))){
                tmp.add(s.substring(index, i + 1));
                backtracking(result, tmp, i+1, s);
                tmp.remove(tmp.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s){
        if(s.length()==1){
            return true;
        }

        System.out.println("String check:" + s);
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
