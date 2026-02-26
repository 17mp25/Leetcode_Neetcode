package arrays_and_hashing;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
            String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
            GroupAnagrams ga = new GroupAnagrams();
            List<List<String>> result = ga.groupAnagrams(Arrays.asList(strs));
            System.out.println(result);
            // Expected output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    }
    public List<List<String>> groupAnagrams(List<String> list){
        Map<String, List<String>> map = new HashMap<>();
        for(String str :list){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);
            if(map.computeIfAbsent(s)) {
                {
                    map.put(s, new ArrayList<>());
                    }
                map.put(s, map.get(s).add(str));
            }
        }
        return map;
    }
}
