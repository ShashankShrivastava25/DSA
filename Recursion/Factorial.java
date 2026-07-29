package Recursion;

import java.util.Scanner;

public class Factorial {
    public static int printFactorial(int n) { // TC O(n) SC O(n)
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n < 0) {
            System.out.println("Enter a +ve number");
            return -1;
        }
        return n * printFactorial(n - 1);
    }

    public static void main(String args[]) {
        System.out.print("Enter a Number : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(printFactorial(n));
        sc.close();
    }
}
