package Recursion;

import java.util.Scanner;

public class FibonacciSeries { // TC O(2^n) SC O(n)
    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String args[]) {
        System.out.print("Enter a Number : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(fibonacci(n));
        sc.close();
    }
}
