public class LongestCommonSubstring {
    // TC O(n*m), SC O(n*m)
    public static int lcs(String str1, String str2, int n, int m) {
        int dp[][] = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        // for (int i = 0; i < dp.length; i++) {
        // for (int j = 0; j < dp[0].length; j++) {
        // System.out.print(" " + dp[i][j] + " ");
        // }
        // System.out.println();
        // }
        return ans;

    }

    public static void main(String args[]) {
        String str1 = "abcdgh";
        String str2 = "acdghr";

        System.out.println(lcs(str1, str2, str1.length(), str2.length()));
    }
}
