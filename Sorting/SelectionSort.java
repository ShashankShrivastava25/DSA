package Sorting;

public class SelectionSort { // O(n^2)
    public static void selectionsort(int arr[]) {

        // Increasing Order

        for (int i = 0; i <= arr.length - 2; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minPos] > arr[j]) {
                    minPos = j;
                }

            }
            int temp;
            temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;

        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }

        System.out.println("");

        // Decreasing Order

        for (int i = 0; i <= arr.length - 2; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minPos] < arr[j]) {
                    minPos = j;
                }
            }
            int temp;
            temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }

    }

    public static void main(String args[]) {
        int arr[] = { 2, 3, 6, 5, 1, 4 };
        selectionsort(arr);
    }
}
