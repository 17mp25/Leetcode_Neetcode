package practiceproblems.slidingwindow;

import java.util.HashMap;

public class MinimumLengthSubstring {
    public static String imsString(String s, String t){
        int minLength = Integer.MAX_VALUE;
        String result = "";
        int left = 0;
        int startIndex = 0;
        int matchedCount = 0;

        HashMap<Character,Integer> requiredChars = new HashMap<>();
        for(char c : t.toCharArray()) {
            requiredChars.put(c, requiredChars.getOrDefault(c, 0) + 1);
        }

        HashMap<Character,Integer> windowChars = new HashMap<>();
        for(int right=0;right<s.length();right++){
            char currentChar = s.charAt(right);
            windowChars.put(currentChar,windowChars.getOrDefault(currentChar,0)+1);
            if(requiredChars.containsKey(currentChar) && windowChars.get(currentChar).intValue()==requiredChars.get(currentChar).intValue()){
                matchedCount++;
            }

            while(matchedCount==requiredChars.size()){
                int currentLength = right-left+1;
                if(currentLength<minLength) {
                    minLength = currentLength;
                    startIndex = left;
                }
                char leftChar = s.charAt(left);
                windowChars.put(leftChar, windowChars.getOrDefault(leftChar,0)-1);
                if(requiredChars.containsKey(leftChar) && windowChars.get(leftChar)<requiredChars.get(leftChar)){
                    matchedCount--;
                }
                left++;
            }
        }
        return minLength==Integer.MAX_VALUE?"":s.substring(startIndex,startIndex+minLength);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(imsString(s, t)); // Output: "BANC"
    }
}
