package Recursion;

public class LastOccurenceofKey {
    public static int isPresent(int arr[], int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        int isFound = isPresent(arr, key, i + 1);
        if (isFound == -1 && arr[i] == key) {
            return i;
        }
        return isFound;
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5, 7, 6, 5 };
        int key = 5;
        int i = 0;
        System.out.print("Key is present at index : " + isPresent(arr, key, i));
    }
}
