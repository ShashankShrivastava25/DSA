public class SearchInSortedMatrix {

    // Unsorted array O(n*m)
    public static void searchKey(int arr[][], int key) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == key) {
                    System.out.print("Key is present at (" + i + "," + j + ")");
                    return;
                }
            }
        }
        System.out.print("Key not found");
    }

    // Sorted array O(n+m)
    public static void staircaseSearch(int arr[][], int key) {
        int row = 0;
        int col = arr[0].length - 1;
        while (row < arr.length && col >= 0) {
            if (arr[row][col] == key) {
                System.out.print("Key is present at (" + row + "," + col + ")");
                return;
            } else if (key > arr[row][col]) {
                row++;
            } else {
                col--;
            }
        }
        System.out.print("Key not found");
        return;
    }

    public static void main(String args[]) {
        int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        int key = 15;
        searchKey(arr, key);
        System.out.println(" ");
        staircaseSearch(arr, key);
    }
}
