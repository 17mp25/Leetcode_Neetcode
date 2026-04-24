package arrays_and_hashing;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> countS = new HashMap<>();
        Map<Character, Integer> countT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        }
        return countS.equals(countT);
    }

    public static boolean isAnagramOptimised(String s, String t){
        if(s.length()!=t.length()){
            return false;
        }
        int[] count = new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
        for(int c: count){
            if(c!=0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagramm";
        String t = "nagaramm";
        System.out.println(isAnagram(s, t)); // true
        System.out.println(isAnagramOptimised(s, t)); // true
    }
}
