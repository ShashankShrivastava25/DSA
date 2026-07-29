package Recursion;

import java.util.Scanner;

public class FriendsPairingProblem {
    public static int pairFriend(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        // single
        // int fnm1 = pairFriend(n-1);

        // pair
        // int fnm2 = pairFriend(n - 2);
        // int pairWays = (n - 1) * fnm2;

        // int totalWays = fnm1 + pairWays;
        // return totalWays;

        return pairFriend(n - 1) + (n - 1) * pairFriend(n - 2);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of friends : ");
        int n = sc.nextInt();
        System.out.print("Total no. of ways : " + pairFriend(n));
        sc.close();
    }
}
