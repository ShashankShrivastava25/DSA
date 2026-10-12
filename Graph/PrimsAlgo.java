package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgo {
    public static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static class Pair implements Comparable<Pair> {
        int vertex;
        int cost;

        public Pair(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 3, 50));

    }

    public static int findMinCost(ArrayList<Edge> graph[]) { // TC O(ElogE)
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean visited[] = new boolean[graph.length];
        int totalCost = 0;

        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!visited[curr.vertex]) {
                totalCost += curr.cost;
                visited[curr.vertex] = true;
                for (int i = 0; i < graph[curr.vertex].size(); i++) {
                    Edge e = graph[curr.vertex].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }

        return totalCost;
    }

    public static void main(String args[]) {
        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.print(findMinCost(graph));
    }
}
