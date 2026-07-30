import java.util.HashMap;

public class SubarraySumEqualsToK { // TC O(n)
    public static void main(String args[]) {
        int arr[] = { 10, 2, -2, -20, 10 };
        int k = -10;
        int count = 0; // number of subarray have sum equals to k
        int sum = 0;
        HashMap<Integer, Integer> hm = new HashMap<>(); // sum, count
        hm.put(0, 1);
        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            if (hm.containsKey(sum - k)) {
                count += hm.get(sum - k);
            } else {
                hm.put(sum, hm.getOrDefault(sum, 0) + 1);
            }
        }
        System.out.print("count = " + count);
    }
}
