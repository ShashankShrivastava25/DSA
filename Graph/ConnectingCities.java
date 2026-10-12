package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ConnectingCities {
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
        int v; // vertex
        int cost;

        public Pair(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[], int cities[][]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < cities.length; i++) {
            for (int j = 0; j < cities[0].length; j++) {
                if (cities[i][j] != 0) {
                    Edge e = new Edge(i, j, cities[i][j]);
                    graph[i].add(e);
                }
            }
        }
    }

    public static int minCost(ArrayList<Edge> graph[], int src) { // TC O(ElogE)
        int totalCost = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean visited[] = new boolean[graph.length];

        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!visited[curr.v]) {
                visited[curr.v] = true;
                totalCost += curr.cost;
                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }
        return totalCost;
    }

    public static void main(String args[]) {
        int cities[][] = { { 0, 1, 2, 3, 4 }, { 1, 0, 5, 0, 7 }, { 2, 5, 0, 6, 0 }, { 3, 0, 6, 0, 0 },
                { 4, 7, 0, 0, 0 } };
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[cities.length];
        createGraph(graph, cities);
        int src = 0;
        int ans = minCost(graph, src);
        System.out.print(ans);
    }
}
