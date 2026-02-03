package arrays_and_hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }

        int longestStreak = 0;
        for(int num: set){
            if(!set.contains(num -1)){
                int currentNum = num;
                int currentStreak = 1;

                while(set.contains(currentNum+1)){//Confusion here added debugger and clarified
                    currentNum++;
                    currentStreak+=1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,4,5,2,7,100,101,105,104,103,102,106};
        System.out.println(longestConsecutive(nums)); // Output: 4

    }
}
