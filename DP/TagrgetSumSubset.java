public class TagrgetSumSubset {

    public static boolean targetSum(int num[], int sum) {
        boolean dp[][] = new boolean[num.length + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < num.length + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (num[i - 1] <= j) {
                    // include
                    boolean ans1 = dp[i - 1][j - num[i - 1]];
                    // exclude
                    boolean ans2 = dp[i - 1][j];
                    dp[i][j] = ans1 || ans2;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[num.length][sum];
    }

    public static void main(String args[]) {
        int num[] = { 4, 2, 3, 7, 1 };
        int sum = 10; // target sum

        System.out.print(targetSum(num, sum));
    }
}
