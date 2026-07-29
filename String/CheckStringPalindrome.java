package String;

import java.util.*;

public class CheckStringPalindrome {
    public static boolean checkPalindromNot(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            int n = str.length();
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        System.out.print("Enter a String : ");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if (checkPalindromNot(str)) {
            System.out.print("Given String is a Palindrome");
        } else {
            System.out.print("Given String is not a Palindrome");
        }
        sc.close();
    }
}
