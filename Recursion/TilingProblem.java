package Recursion;

import java.util.Scanner;

public class TilingProblem {
    public static int tilingProblem(int n) { // 2*n floor size, 1*2 tile size
        if (n == 0 || n == 1) {
            return 1;
        }
        // vertical
        // int fnm1 = tilingProblem(n - 1);
        // horizontal
        // int fnm2 = tilingProblem(n - 2);
        // int totalWays = fnm1 + fnm2;
        // return totalWays;

        return tilingProblem(n - 1) + tilingProblem(n - 2);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of n : ");
        int n = sc.nextInt();
        System.out.print("Total number of ways are : " + tilingProblem(n));
        sc.close();
    }
}
