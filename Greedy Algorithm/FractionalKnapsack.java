import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack { // TC = O(n + nlogn + n) = O(nlogn), SC O(n)
    public static void main(String args[]) {
        int weight[] = { 10, 30, 20 };
        int value[] = { 60, 120, 100 };
        int W = 50; // total capacity of knapsack

        int capacity = W; // track left capacity of knapsack
        int tp = 0; // total Profit

        double ratio[][] = new double[weight.length][2];
        for (int i = 0; i < ratio.length; i++) { // O(n)
            ratio[i][0] = i;
            ratio[i][1] = value[i] / (double) weight[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1])); // sort in ascending order O(nlogn)

        for (int i = ratio.length - 1; i >= 0; i--) { // O(n)
            int idx = (int) ratio[i][0];
            if (capacity >= weight[idx]) {
                capacity -= weight[idx];
                tp += value[idx];
            } else {
                tp += ratio[i][1] * capacity;
                capacity = 0;
                break;
            }
        }
        System.out.print("Maximum profit obtained is " + tp);
    }
}
