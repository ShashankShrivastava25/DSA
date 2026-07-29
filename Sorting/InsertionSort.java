package Sorting;

public class InsertionSort {
    public static void insertionsort(int arr[]) {

        // Increasing Order

        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int prev = i - 1;
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = curr;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }

        System.out.println();

        // Decreasing Order

        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int prev = i - 1;
            while (prev >= 0 && arr[prev] < curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = curr;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }

    }

    public static void main(String args[]) {
        int arr[] = { 2, 3, 6, 5, 1, 4 };
        insertionsort(arr);
    }
}
