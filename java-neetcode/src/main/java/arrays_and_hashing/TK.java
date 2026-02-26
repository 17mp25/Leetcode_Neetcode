package arrays_and_hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TK {
    public static int[] tt(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->map.get(a)-map.get(b));
        for(int key : map.keySet()){
            pq.add(key);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int res[] = new int[k];
        for(int i = k-1;i>0;i--){
            res[i] = pq.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] result = tt(nums, k);
    }
}
