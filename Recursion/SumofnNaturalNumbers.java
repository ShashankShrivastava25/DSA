package Recursion;

import java.util.Scanner;

public class SumofnNaturalNumbers {
    public static int printSumofNaturalNo(int n) {
        if (n == 1) {
            return 1;
        }
        return n + printSumofNaturalNo(n - 1);
    }

    public static void main(String args[]) {
        System.out.print("Enter a Number : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(printSumofNaturalNo(n));
        sc.close();
    }
}
