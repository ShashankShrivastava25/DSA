public class KadanesAlgo {
    public static void findMaxSum(int arr[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            currSum = currSum + arr[i];
            if (currSum < 0) {
                currSum = 0;
            }
            maxSum = Math.max(currSum, maxSum);
        }
        System.out.println("Maximum Sum is :" + maxSum);
    }

    public static void main(String args[]) {
        int arr[] = { 1, -1, -2, -2, -3, 4, -1, 5, -3 };
        findMaxSum(arr); // O(n)
    }
}
