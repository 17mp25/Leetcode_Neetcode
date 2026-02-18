package arrays_and_hashing;

import java.util.HashMap;
import java.util.Map;

public class RepeatedStrings {
    public static void repeatedStrings(String s) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : s.split(" ")) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        int repeatedCount = 0;
        int nonRepeatedCount = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(
                        "Repeated String: " + entry.getKey() + ", Count: " + entry.getValue());
                repeatedCount++;
            } else {
                System.out.println("Non-Repeated String: " + entry.getKey());
                nonRepeatedCount++;
            }
        }
    }
    public static void main(String[] args){
        RepeatedStrings rs = new RepeatedStrings();
        String s = "hello world hello java java neetcode";
        rs.repeatedStrings(s);
    }
}
