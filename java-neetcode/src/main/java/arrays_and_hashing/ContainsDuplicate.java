package arrays_and_hashing;

import java.util.Arrays;

public class ContainsDuplicate {

    public static boolean hasDuplicateWithoutExtraSpace(int[] nums) {
        Arrays.sort(nums);
        int j=1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[j]){
                return true;
            }
            j++;
        }
        return false;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,1};
        System.out.println(hasDuplicateWithoutExtraSpace(arr));
    }
}
