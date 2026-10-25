public class ZeroOneKnapsack {
    // Recursion - TC O(2^n), n -> no. of weights
    public static int knapsack(int val[], int wt[], int W, int i) {
        if (W == 0 || i == 0) {
            return 0;
        }
        if (wt[i - 1] <= W) {
            // include
            int ans1 = val[i - 1] + knapsack(val, wt, W - wt[i - 1], i - 1);
            // exclude
            int ans2 = knapsack(val, wt, W, i - 1);

            return Math.max(ans1, ans2);
        } else {
            return knapsack(val, wt, W, i - 1);
        }
    }

    // Memoization - TC O(n * W)
    public static int knapsack1(int val[], int wt[], int W, int i, int dp[][]) {
        if (W == 0 || i == 0) {
            return 0;
        }
        if (dp[i][W] != -1) {
            return dp[i][W];
        }
        if (wt[i - 1] <= W) {
            // include
            int ans1 = val[i - 1] + knapsack1(val, wt, W - wt[i - 1], i - 1, dp);
            // exclude
            int ans2 = knapsack1(val, wt, W, i - 1, dp);

            dp[i][W] = Math.max(ans1, ans2);
            return dp[i][W];
        } else {
            dp[i][W] = knapsack1(val, wt, W, i - 1, dp);
            return dp[i][W];
        }
    }

    // print 2D array
    // public static void print(int dp[][]) {
    // for (int i = 0; i < dp.length; i++) {
    // for (int j = 0; j < dp[0].length; j++) {
    // System.out.print(dp[i][j] + " ");
    // }
    // System.out.println();
    // }
    // }

    // Tabulation - TC O(n * W)
    public static int knapsack2(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];

        // Initialize base cases
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (wt[i - 1] <= j) {
                    // include
                    int ans1 = val[i - 1] + dp[i - 1][j - wt[i - 1]];
                    // exclude
                    int ans2 = dp[i - 1][j];

                    dp[i][j] = Math.max(ans1, ans2);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        // print(dp);
        return dp[n][W];
    }

    public static void main(String args[]) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;

        System.out.println(knapsack(val, wt, W, val.length)); // recursion

        int dp[][] = new int[val.length + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(knapsack1(val, wt, W, val.length, dp)); // memoization

        System.out.println(knapsack2(val, wt, W)); // tabulation
    }
}
