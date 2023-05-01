package twopointer;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {

        int firstIndex = 0;
        int lastIndex = s.length()-1;
        for(;firstIndex < lastIndex;){
            if(!Character.isLetterOrDigit(s.charAt(firstIndex))){
                firstIndex++;
            }else if(!Character.isLetterOrDigit(s.charAt(lastIndex))){
                lastIndex--;
            } else{
                if(Character.toLowerCase(s.charAt(firstIndex)) != Character.toLowerCase(s.charAt(lastIndex))){
                    return false;
                }
                firstIndex++;
                lastIndex--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome v = new ValidPalindrome();
        System.out.println(v.isPalindrome("Marge, let's \\\"[went].\\\" I await {news} telegram."));
    }
}
