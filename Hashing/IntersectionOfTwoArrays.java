import java.util.HashSet;

public class IntersectionOfTwoArrays { // TC O(m + n)
    public static void main(String args[]) {
        int arr1[] = { 1, 2, 3, 4, 5 }; // m size
        int arr2[] = { 3, 4, 5, 3, 6, 7, 8, 9 }; // n size
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) { // O(m)
            hs.add(arr1[i]);
        }
        int count = 0;
        for (int i = 0; i < arr2.length; i++) { // O(n)
            if (hs.contains(arr2[i])) {
                count++;
                System.out.print(arr2[i] + " ");
                hs.remove(arr2[i]);
            }
        }
        System.out.println();
        System.out.print("count = " + count);
    }
}
