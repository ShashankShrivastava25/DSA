import java.util.ArrayList;
import java.util.Collections;

public class JobSequencingProblem { // TC O(nlogn), SC O(n)

    public static class Job {
        int deadline;
        int profit;
        int id;

        public Job(int i, int d, int p) {
            this.id = i;
            this.deadline = d;
            this.profit = p;
        }
    }

    public static void main(String args[]) {
        int jobInfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };
        int time = 0;
        int maxProfit = 0;
        ArrayList<Job> jobs = new ArrayList<>();

        for (int i = 0; i < jobInfo.length; i++) { // O(n)
            jobs.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));
        }

        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit); // O(nlogn)

        ArrayList<Integer> seq = new ArrayList<>();
        for (int i = 0; i < jobs.size(); i++) { // O(n)
            Job curr = jobs.get(i);
            if (curr.deadline > time) {
                seq.add(curr.id);
                maxProfit += curr.profit;
                time++;
            }
        }

        System.out.println("Max jobs = " + seq.size());
        System.out.println("Max profit = " + maxProfit);
        for (int i = 0; i < seq.size(); i++) { // O(n)
            System.out.print(seq.get(i) + " ");
        }
        System.out.println();
    }
}
