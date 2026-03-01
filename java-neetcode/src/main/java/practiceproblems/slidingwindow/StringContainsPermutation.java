package practiceproblems.slidingwindow;

import java.util.Arrays;

public class StringContainsPermutation {
    public static boolean check(String s1, String s2){
        int [] s1Count = new int[26];
        int [] s2Count = new int[26];
        int left=0;
        for(char c: s1.toCharArray()){
            s1Count[c-'a']++;
        }
        for(int right=0;right<s2.length();right++){
            int currentChar = s2.charAt(right);
            s2Count[currentChar-'a']++;
            int windowSize = right-left+1;
            if(windowSize>s1.length()){
                char leftChar = s2.charAt(left);
                s2Count[leftChar-'a']--;
                left++;
            }
            if(Arrays.equals(s1Count,s2Count)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "eidbaooo";
        System.out.println(check(s1, s2)); // Output: true (because "baoo" contains a permutation of "abc")
    }
}
