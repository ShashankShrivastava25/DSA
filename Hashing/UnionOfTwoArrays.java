import java.util.HashSet;

public class UnionOfTwoArrays { // TC O(m + n)
    public static void main(String args[]) {
        int arr1[] = { 1, 2, 3, 4, 5 }; // m size
        int arr2[] = { 3, 4, 5, 6, 7, 8, 9 }; // n size
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) { // O(m)
            hs.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) { // O(n)
            hs.add(arr2[i]);
        }
        System.out.println(hs);
        System.out.println(hs.size());
    }
}
