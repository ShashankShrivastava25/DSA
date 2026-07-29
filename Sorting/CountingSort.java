package Sorting;

public class CountingSort {
    // Efficient for short range or small arrays , TC O(n)
    public static void countingsort(int arr[]) {
        int Largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            Largest = Math.max(arr[i], Largest);
        }
        int count[] = new int[Largest + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void main(String args[]) {
        int arr[] = { 1, 3, 5, 7, 5, 4, 2, 3 };
        countingsort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
