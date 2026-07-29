public class LinearSearch {
    public static int linearsearch(int arr[], int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;

    }

    public static void main(String args[]) {
        int arr[] = { 1, 3, 4, 5, 6, 7, 8 };
        int key = 6;
        int ans = linearsearch(arr, key);
        System.out.println("Key is present at index :" + ans);

    }
}
