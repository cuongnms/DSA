package arrayhashing;

import java.util.Arrays;

public class ValidAnagram {
//    public static boolean isAnagram(String s, String t) {
//        if(t.length() != s.length()){
//            return false;
//        }
//        char[] tArray = t.toCharArray();
//        char[] sArray = s.toCharArray();
//
//        Arrays.sort(tArray);
//        Arrays.sort(sArray);
//        return Arrays.toString(tArray).equals(Arrays.toString(sArray));
//    }

    public static boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(ValidAnagram.isAnagram("anagram", "nagaram"));

    }

}
