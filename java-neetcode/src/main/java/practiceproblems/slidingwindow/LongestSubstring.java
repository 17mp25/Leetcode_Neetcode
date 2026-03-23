package practiceproblems.slidingwindow;
import java.util.*;

public class LongestSubstring {

    public static int longestSustring(String s){
        int left = 0;
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        for(int right = 0; right < s.length(); right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcbcdefghijklkkjzk";
        System.out.println(longestSustring(s)); // Output: 3 (for "abc")
    }
}

