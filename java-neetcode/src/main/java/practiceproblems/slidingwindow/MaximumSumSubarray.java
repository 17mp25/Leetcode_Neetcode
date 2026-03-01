package practiceproblems.slidingwindow;

public class MaximumSumSubarray {
    public static int maxSumSubarray(int [] nums,int k){
        int maxSum =Integer.MIN_VALUE;
        int currentSum = 0;
        for(int i = 0;i<k;i++){
            currentSum+=nums[i];
        }
        for(int i=k;i<nums.length;i++){
            currentSum= currentSum+nums[i]-nums[i-k];
            maxSum = Math.max(maxSum,currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5,6};
        int k = 3;
        System.out.println(maxSumSubarray(nums,k)); // Output: 15 (for subarray [4,5,6])
    }
}
