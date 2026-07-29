package Heaps;

public class HeapSort { // TC O(nlogn)

    public static void heapify(int arr[], int i, int size) { // O(logn)
        int maxIdx = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < size && arr[maxIdx] < arr[left]) {
            maxIdx = left;
        }
        if (right < size && arr[maxIdx] < arr[right]) {
            maxIdx = right;
        }
        if (maxIdx != i) {
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[i];
            arr[i] = temp;
            heapify(arr, maxIdx, size);
        }
    }

    public static void heapSort(int arr[]) {
        // step 1 :- build max heap
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) { // O(n*logn)
            heapify(arr, i, n);
        }
        // step 2 :- swap largest & end
        for (int i = n - 1; i > 0; i--) { // O(n*logn)
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, 0, i);
        }
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 4, 5, 3 };
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
