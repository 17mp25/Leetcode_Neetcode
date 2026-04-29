package arrays_and_hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static boolean hasDuplicateWithoutExtraSpace(int[] nums) {
        Arrays.sort(nums);
        int j=1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[j]){
                return true;
            }
            j=j+1;
        }
        return false;
    }

    public static boolean hasDuplicateWithExtraSpace(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(!set.add(num)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,1,5};
        System.out.println(hasDuplicateWithoutExtraSpace(arr));
        System.out.println(hasDuplicateWithExtraSpace(arr));
    }
}
