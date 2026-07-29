package Stack;

import java.util.*;

public class ReverseStringUsingStack {
    public static String reverse(String str) {
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder sb = new StringBuilder("");
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        String str = "abcd";
        String resultStr = reverse(str);
        int j = 0;
        while (j < resultStr.length()) {
            System.out.println(resultStr.charAt(j));
            j++;
        }
    }
}
