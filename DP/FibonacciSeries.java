public class FibonacciSeries {
    // Memoiozation
    public static int fib1(int n, int f[]) { // TC O(n)
        if (n == 0 || n == 1) {
            return n;
        }
        if (f[n] != 0) {
            return f[n];
        }
        f[n] = fib1(n - 1, f) + fib1(n - 2, f);
        return f[n];
    }

    // Tabulation
    public static int fib2(int n, int dp[]) { // TC O(n)
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String args[]) {
        int n = 6;
        int f[] = new int[n + 1];
        int dp[] = new int[n + 1];

        System.out.println(fib1(n, f)); // memoization
        System.out.println(fib2(n, dp)); // tabulation
    }
}
