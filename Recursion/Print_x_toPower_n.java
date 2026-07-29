package Recursion;

import java.util.Scanner;

public class Print_x_toPower_n {
    public static int power(int x, int n) { // O(n)
        if (n == 0) {
            return 1;
        }
        return x * power(x, n - 1);
    }

    public static int powerOptimized(int x, int n) { // O(log n)
        if (n == 0) {
            return 1;
        }
        int halfPower = powerOptimized(x, n / 2);
        int halfPowerSq = halfPower * halfPower;
        if (n % 2 != 0) {
            return x * halfPowerSq;
        }
        return halfPowerSq;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of x : ");
        int x = sc.nextInt();
        System.out.print("Enter value of n : ");
        int n = sc.nextInt();
        System.out.println(power(x, n));
        System.out.println(powerOptimized(x, n));
        sc.close();
    }
}
