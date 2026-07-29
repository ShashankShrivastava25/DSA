public class BinarySearch {
    public static int binarysearch(int arr[], int key, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        int key = 5;
        int start = 0;
        int end = arr.length - 1;
        System.out.println("Element is present at index :" + binarysearch(arr, key, start, end));
    }
}
