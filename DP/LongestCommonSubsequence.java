public class LongestCommonSubsequence {
    // Recursion - TC O(2^(n+m))
    public static int lcs(String str1, String str2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return 1 + lcs(str1, str2, n - 1, m - 1);
        } else {
            return Math.max(lcs(str1, str2, n - 1, m), lcs(str1, str2, n, m - 1));
        }
    }

    // Memoization - TC O(n*m)
    public static int lcs1(String str1, String str2, int n, int m, int dp[][]) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return dp[n][m] = 1 + lcs1(str1, str2, n - 1, m - 1, dp);
        } else {
            return dp[n][m] = Math.max(lcs1(str1, str2, n, m - 1, dp), lcs1(str1, str2, n - 1, m, dp));
        }
    }

    // Tabulation - TC O(n*m)
    public static int lcs2(String str1, String str2, int n, int m) {
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String args[]) {
        String str1 = "abcdge";
        String str2 = "abedg";

        System.out.println(lcs(str1, str2, str1.length(), str2.length())); // recursion

        int dp[][] = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(lcs1(str1, str2, str1.length(), str2.length(), dp)); // memoization

        System.out.println(lcs2(str1, str2, str1.length(), str2.length())); // tabulation
    }
}
