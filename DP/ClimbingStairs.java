import java.util.Arrays;

public class ClimbingStairs {
    // Recursion - TC O(2^n)
    public static int countWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        return countWays(n - 1) + countWays(n - 2);
    }

    // Memoization - TC O(n)
    public static int countWays1(int n, int dp[]) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = countWays(n - 1) + countWays(n - 2);
        return dp[n];
    }

    // Tabulation - TC O(n)
    public static int countWays2(int n, int dp[]) {
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String args[]) {
        int n = 6; // n -> no. of stairs
        System.out.println(countWays(n));

        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(countWays1(n, dp)); // Memoization
        Arrays.fill(dp, -1);
        System.out.println(countWays2(n, dp)); // Tabulation
    }
}
