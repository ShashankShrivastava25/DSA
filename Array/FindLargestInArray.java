public class FindLargestInArray {
    public static void findLargest(int arr[]) {
        int Largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > Largest) {
                Largest = arr[i];
            }

        }
        System.out.println("Largest value of array is :" + Largest);
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        findLargest(arr);
    }
}
