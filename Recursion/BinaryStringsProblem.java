package Recursion;

import java.util.Scanner;

public class BinaryStringsProblem {
    public static void printBinStr(int n, int lastPlace, String str) {
        if (n == 0) {
            System.out.println(str);
            return;
        }
        printBinStr(n - 1, 0, str + '0');
        if (lastPlace == 0) {
            printBinStr(n - 1, 1, str + '1');
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n : ");
        int n = sc.nextInt();
        int lastPlace = 0;
        String str = "";
        printBinStr(n, lastPlace, str);
        sc.close();
    }
}
