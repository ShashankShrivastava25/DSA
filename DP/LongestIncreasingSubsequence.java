import java.util.HashSet;
import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static int lis(int arr1[], int arr2[]) { // TC O(n*m)
        int n = arr1.length;
        int m = arr2.length;
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String args[]) {
        int arr[] = { 50, 3, 10, 7, 40, 80 };
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int arr2[] = new int[set.size()];
        int i = 0;
        for (int num : set) {
            arr2[i] = num;
            i++;
        }
        Arrays.sort(arr2);

        System.out.println(lis(arr, arr2));
    }
}
