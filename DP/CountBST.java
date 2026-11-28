public class CountBST {

    public static int countBst(int n) { // TC O(n^2)
        int dp[] = new int[n + 1];
        dp[0] = dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            for (int j = 0; j <= i - 1; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public static void main(String args[]) {
        int a[] = { 10, 20, 30, 40, 50 };

        System.out.println(countBst(a.length));
    }
}
