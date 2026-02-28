package arrays_and_hashing;

import java.util.ArrayList;
import java.util.List;

public class ReverseString {
    public static void main(String[] args) {
        String s = "I am a Java developer";
        String result = solution(s);
        System.out.println(result);

    }

    public static String solution(String s) {
        List<String> list = new ArrayList<>();
        String[] str = s.split(" ");
        for(String st : str){
            list.add(reverse(st));
        }
        return String.join(" ", list);
    }

    public static String reverse(String s){
        int left = 0;
        int right = s.length()-1;
        char[] arr = s.toCharArray();
        while(left<right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return new String(arr);
    }
}
