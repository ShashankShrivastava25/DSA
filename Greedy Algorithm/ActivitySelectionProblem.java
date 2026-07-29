import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelectionProblem { // TC = O(n + n + nlogn + n) = O(nlogn)
    public static void main(String args[]) {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 }; // must be sorted
        int maxAct = 0; // count max no. of activity
        ArrayList<Integer> ans = new ArrayList<>(); // used to store the index of choosed activity

        // if end time is not sorted
        int activities[][] = new int[start.length][3];
        for (int i = 0; i < end.length; i++) { // O(n)
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2])); // O(n logn)
        // lamba function used to sort 2d array

        // 1st activity
        maxAct = 1;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];
        for (int i = 1; i < end.length; i++) { // O(n)
            if (activities[i][1] >= lastEnd) {
                ans.add(activities[i][0]);
                maxAct++;
                lastEnd = activities[i][2];
            }
        }
        System.out.println("Max activity = " + maxAct);
        for (int i = 0; i < ans.size(); i++) { // O(n)
            System.out.print("A" + ans.get(i) + " ");
        }
    }
}
