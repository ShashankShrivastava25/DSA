public class DiagonalSum {
    public static void printDiagonalSum(int arr[][]) { // O (n^2)
        int pd = 0; // pd -> Primary Diagonal
        int sd = 0; // sd -> Secondary Diagonal

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i == j) {
                    pd = pd + arr[i][j];
                }
                if (i + j == arr.length - 1) {
                    if (i != j) {
                        sd = sd + arr[i][j];
                    }
                }
            }
        }
        int sum = pd + sd;
        System.out.println("Diagonal element Sum is : " + sum);
    }

    public static void printDiagonalSumOpt(int arr[][]) { // O (n)
        int pd = 0;
        int sd = 0;
        for (int i = 0; i < arr.length; i++) {
            pd = arr[i][i] + pd;
            if (i != arr.length - 1 - i) {
                sd = sd + arr[i][arr.length - 1 - i];
            }
        }
        int sum = pd + sd;
        System.out.print("Diagonal element Sum is : " + sum);
    }

    public static void main(String args[]) {
        int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        printDiagonalSum(arr);
        printDiagonalSumOpt(arr);
    }
}
