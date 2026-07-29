package Recursion;

public class FirstOccurenceofKey {
    public static int isPresent(int arr[], int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return isPresent(arr, key, i + 1);
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5, 7, 6 };
        int key = 5;
        int i = 0;
        System.out.print("Key is present at index : " + isPresent(arr, key, i));
    }
}
