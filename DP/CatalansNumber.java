import java.util.Arrays;

public class CatalansNumber {
    // Recursion
    public static int printCatalan(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += printCatalan(i) * printCatalan(n - i - 1);
        }
        return ans;
    }

    // Memoization
    public static int printCatalan1(int n, int dp[]) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += printCatalan1(i, dp) * printCatalan1(n - i - 1, dp);
        }
        return dp[n] = ans;
    }

    // Tabulation - TC O(n^2)
    public static int printCatalan2(int n) {
        int dp[] = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j <= i - 1; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public static void main(String args[]) {
        int n = 5;

        System.out.println(printCatalan(n)); // Recursion

        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(printCatalan1(n, dp)); // Memoization

        System.out.println(printCatalan2(n)); // Tabulation
    }
}
