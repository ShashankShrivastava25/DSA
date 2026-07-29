package Hashing;

import java.util.HashMap;

public class MajorityElement { // TC O(n)
    public static void main(String args[]) {
        int arr[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {

            // if (hm.containsKey(num)) {
            // hm.put(num, hm.get(num) + 1);
            // } else {
            // hm.put(num, 1);
            // }

            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }
        for (Integer key : hm.keySet()) {
            if (hm.get(key) > arr.length / 3) {
                System.out.print(key + " ");
            }
        }
    }
}
