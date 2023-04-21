package arrayhashing;

import java.util.*;

public class AnagramGroup {


    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mapResult = new HashMap<>();
        for (String str: strs) {
            char[] charactersInStr = str.toCharArray();
            char[] hash = new char[26];
            for(char c: charactersInStr){
                hash[c-'a']++;
            }
            if(!mapResult.containsKey(String.valueOf(hash))){
                mapResult.put(String.valueOf(hash), new ArrayList<>());
            }
            mapResult.get(String.valueOf(hash)).add(str);
        }

        return new ArrayList<>(mapResult.values());
    }

    public static void main(String[] args) {

        AnagramGroup a = new AnagramGroup();
        List<List<String>> result = a.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        for (List<String> list: result) {
            System.out.print(Arrays.toString(list.toArray()));
            System.out.println();
        }
    }
}
