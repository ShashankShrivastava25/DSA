public class SpiralMatrix {
    public static void printSpiral(int arr[][]) {
        int sr = 0; // sr -> starting row
        int er = arr.length - 1; // er -> ending row
        int sc = 0; // sc -> starting column
        int ec = arr[0].length - 1; // ec -> ending column

        while (sr <= er && sc <= ec) {
            for (int j = sc; j <= ec; j++) {
                System.out.print(arr[sr][j] + " ");
            }
            for (int i = sr + 1; i <= er; i++) {
                System.out.print(arr[i][ec] + " ");
            }
            for (int j = ec - 1; j >= sc; j--) {
                if (sr == er) {
                    break;
                }
                System.out.print(arr[er][j] + " ");
            }
            for (int i = er - 1; i >= sr + 1; i--) {
                if (sc == ec) {
                    break;
                }
                System.out.print(arr[i][sc] + " ");
            }
            sr++;
            sc++;
            er--;
            ec--;
        }

    }

    public static void main(String args[]) {
        int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        printSpiral(arr);
    }
}
