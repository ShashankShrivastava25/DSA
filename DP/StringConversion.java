public class StringConversion {
    public static int stringConversion(String str1, String str2) { // TC O(n*m)
        int n = str1.length();
        int m = str2.length();
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
        int lcs = dp[n][m];
        int deletion = n - lcs;
        int insertion = m - lcs;
        return insertion + deletion;
    }

    public static void main(String args[]) {
        String str1 = "abcdef";
        String str2 = "aceg";

        System.out.println(stringConversion(str1, str2));
    }
}
