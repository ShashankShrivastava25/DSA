package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class InterleaveTwoHalvesOfaQueue {

    public static void interleave(Queue<Integer> q) { // TC O(n)
        int size = q.size();
        Queue<Integer> q2 = new LinkedList<>();
        for (int i = 0; i < size / 2; i++) {
            q2.add(q.remove());
        }
        while (!q2.isEmpty()) {
            q.add(q2.remove());
            q.add(q.remove());
        }
    }

    public static void main(String args[]) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            q.add(i);
        }
        interleave(q);
        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
    }
}
