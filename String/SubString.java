package String;

import java.util.*;

public class SubString { // O(n)
    public static void printSubstring(String str, int si, int ei) {
        String subStr = "";
        for (int i = si; i <= ei; i++) {
            subStr += str.charAt(i);
        }
        System.out.println("Substring is : " + subStr);
    }

    public static void main(String args[]) {
        System.out.print("Enter a String : ");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print("Enter starting index : ");
        int si = sc.nextInt();
        System.out.print("Enter ending index : ");
        int ei = sc.nextInt();
        printSubstring(str, si, ei);
        sc.close();
    }
}
