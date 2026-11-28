public class MountainsRanges {
    public static int countMountainRanges(int n) { // TC O(n^2)
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

        System.out.println(countMountainRanges(5));
    }
}
