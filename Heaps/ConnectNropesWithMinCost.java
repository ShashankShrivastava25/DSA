package Heaps;

import java.util.PriorityQueue;

public class ConnectNropesWithMinCost {
    public static void main(String args[]) {
        int ropes[] = { 2, 3, 3, 4, 6 };
        int minCost = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }
        while (pq.size() > 1) {
            int a = pq.remove();
            int b = pq.remove();
            int cost = a + b;
            minCost += cost;
            pq.add(cost);
        }
        System.out.print(minCost);
    }
}
