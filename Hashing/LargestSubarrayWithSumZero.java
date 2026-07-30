import java.util.HashMap;

public class LargestSubarrayWithSumZero { // TC O(n)
    public static void main(String args[]) {
        int arr[] = { 15, -2, 2, -8, 1, 7, 10 };
        HashMap<Integer, Integer> hm = new HashMap<>(); // sum, idx
        int sum = 0;
        int length = 0; // length of maximum subarray whose sum is zero
        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            if (hm.containsKey(sum)) {
                length = Math.max(length, j - hm.get(sum));
            } else {
                hm.put(sum, j);
            }
        }
        System.out.print("Length = " + length);
    }
}
