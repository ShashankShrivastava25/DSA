import java.util.Arrays;
import java.util.Comparator;

public class MaxLengthChainofPairs { // TC O(nlogn)
    public static void main(String args[]) {
        int arr[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };
        Arrays.sort(arr, Comparator.comparingDouble(o -> o[1])); // O(nlogn)
        int chainLen = 1;
        int lastEnd = arr[0][1]; // end of 1st pair

        for (int i = 1; i < arr.length; i++) { // O(n)
            if (arr[i][0] > lastEnd) {
                chainLen++;
                lastEnd = arr[i][1];
            }
        }
        System.out.print("Maximum length of chain = " + chainLen);
    }
}
