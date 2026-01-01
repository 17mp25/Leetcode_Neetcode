package arrays_and_hashing;

import java.util.HashMap;
import java.util.Map;

public class twoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public static int[] twoSum2PointersForSorted(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                return new int[]{left, right};
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 11};
        int target = 9;
        int[] result = twoSum(nums, target);
        int[] resultSorted = twoSum2PointersForSorted(nums, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
        System.out.println(
                "Indices (Sorted): [" + resultSorted[0] + ", " + resultSorted[1] + "]");
    }
}
