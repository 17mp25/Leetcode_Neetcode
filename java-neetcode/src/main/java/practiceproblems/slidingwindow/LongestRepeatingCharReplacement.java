package practiceproblems.slidingwindow;

public class LongestRepeatingCharReplacement {
    public static int charReplacement(String s, int k) {
        int[] chrCount = new int[26];
        int left = 0;
        int maxCount = 0;
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            chrCount[currentChar - 'A']++;
            maxCount = Math.max(maxCount, chrCount[currentChar-'A']);
            int windowSize = right - left + 1;
            if (windowSize - maxCount > k) {
                char leftChar = s.charAt(left);
                chrCount[leftChar-'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "ABAB";
        int k = 1;
        System.out.println(charReplacement(s, k)); // Output: 4 (for "AABA" or "ABBA")
    }
}
