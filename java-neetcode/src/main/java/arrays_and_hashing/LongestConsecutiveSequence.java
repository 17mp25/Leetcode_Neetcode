package arrays_and_hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static int l(int[] numbers){
       Set<Integer> set = new HashSet<>();
       for(int num : numbers){
           set.add(num);
       }
       int longestStreak = 0;
       for(int num : set){
           if(!set.contains(num -1)){
               int currentNum = num;
               int count = 1;
               while(set.contains(currentNum+1)){
                   currentNum++;
                   count++;
               }
               longestStreak = Math.max(longestStreak, count);
           }
       }
        return longestStreak;
    }

    public static int longConsecutiveCharInString(String s){
        Set<Character> set = new HashSet<>();
        for(char c :s.toCharArray()){
            set.add(c);
        }
        int longestStreak = 0;
        for(char c: set){
            if(!set.contains((char)c-1)){
                char currentChar = c;
                int currentStreak = 1;

                while(set.contains((char)(currentChar+1))){
                    currentChar++;
                    currentStreak++;
                }
                longestStreak = Math.max(currentStreak, longestStreak);
            }

        }
        return longestStreak;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,4,5,2,7,100,101,105,104,103,102,106};
        String s = "aabccdefg";
        //System.out.println(longConsecutiveCharInString(s)); // Output: 10 (for
        System.out.println(l(nums)); // Output: 4

    }
}
