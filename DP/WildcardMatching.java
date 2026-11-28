public class WildcardMatching {

    public static boolean isMatch(String s, String p) { // TC O(n*m)
        int n = s.length();
        int m = p.length();
        boolean dp[][] = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = false;
        }
        for (int i = 1; i < dp[0].length; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 1];
            } else {
                dp[0][i] = false;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    boolean ans1 = dp[i][j - 1]; // * -> null
                    boolean ans2 = dp[i - 1][j]; // * -> any character or sequence of character
                    dp[i][j] = ans1 || ans2;
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String args[]) {
        String str = "baaabab";
        String pattern = "*****ba*****ab";

        System.out.println(isMatch(str, pattern));
    }
}
