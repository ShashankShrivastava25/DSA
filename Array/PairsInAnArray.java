public class PairsInAnArray {
    public static void pairArrayElement(int arr[]) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.println("(" + arr[i] + "," + arr[j] + ")");
                count++;
            }
        }
        System.out.println("Total no of pairs is :" + count);
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        pairArrayElement(arr);
    }
}
