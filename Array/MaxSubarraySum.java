public class MaxSubarraySum {
    // Brute Force O(n^3)
    public static void maxSubArraySum(int arr[], int Largest) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = i; k <= j; k++) {
                    sum = sum + arr[k];
                }
                if (sum > Largest) {
                    Largest = sum;
                }
                sum = 0;
            }
        }
        System.out.println("Largest Subarray Sum is :" + Largest);
    }

    // Prefix Array O(n^2)
    public static void maxSubArraySumTwo(int arr[], int Largest) {
        int currSum = 0;

        int prefixSum[] = new int[arr.length];
        prefixSum[0] = arr[0];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i + 1; j < arr.length; j++) {
                int end = j;
                currSum = start == 0 ? prefixSum[end] : prefixSum[end] - prefixSum[start - 1];
                if (currSum > Largest) {
                    Largest = currSum;
                }
                currSum = 0;
            }
        }
        System.out.println("Largest Subarray Sum is :" + Largest);
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5 };
        int Largest = Integer.MIN_VALUE;
        maxSubArraySum(arr, Largest);
        maxSubArraySumTwo(arr, Largest);
    }
}
