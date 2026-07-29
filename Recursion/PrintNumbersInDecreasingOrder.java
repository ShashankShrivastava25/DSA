package Recursion;

import java.util.Scanner;

public class PrintNumbersInDecreasingOrder {
    public static void printNumber(int n) {
        if (n == 0) {
            System.out.print(n);
            return;
        }
        System.out.print(n + " ");
        printNumber(n - 1);
    }

    public static void main(String args[]) {
        System.out.print("Enter a Number : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printNumber(n);
        sc.close();
    }
}
