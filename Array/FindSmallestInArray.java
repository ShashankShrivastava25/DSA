public class FindSmallestInArray {
    public static void findSmallest(int arr[]) {
        int Smallest = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < Smallest) {
                Smallest = arr[i];
            }

        }
        System.out.println("Smallest value of array is :" + Smallest);
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        findSmallest(arr);
    }
}
