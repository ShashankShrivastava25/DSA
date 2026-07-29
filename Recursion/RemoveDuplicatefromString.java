package Recursion;

import java.util.Scanner;

public class RemoveDuplicatefromString {
    public static void removeDuplicate(String str, StringBuilder sb, int idx, boolean map[]) {
        if (idx == str.length()) {
            System.out.println(sb);
            return;
        }
        char currChar = str.charAt(idx);
        if (map[currChar - 'a'] == true) {
            removeDuplicate(str, sb, idx + 1, map);
        } else {
            map[currChar - 'a'] = true;
            removeDuplicate(str, sb.append(currChar), idx + 1, map);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String : ");
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder(" ");
        int idx = 0;
        boolean map[] = new boolean[26];
        removeDuplicate(str, sb, idx, map);
        sc.close();
    }
}
