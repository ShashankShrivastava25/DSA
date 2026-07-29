package Sorting;

public class BubbleSort { // TC O(n^2) SC O(1)
    public static void bubbleSort(int arr[]) {
        int swap = 0;
        // i -> no. of turns
        for (int i = 0; i <= arr.length - 2; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap++;
                }
            }
            // if it is already sorted then TC O(n)
            if (swap == 0) {
                System.out.println("Array is already sorted");
                for (int k = 0; k < arr.length; k++) {
                    System.out.print(arr[k]);
                }
                return;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5 };
        bubbleSort(arr);
    }
}
