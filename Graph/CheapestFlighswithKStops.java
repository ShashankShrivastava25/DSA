package Graph;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class CheapestFlighswithKStops {
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

    public static class Info {
        int v; // vertex
        int cost; // total cost from src to node
        int stops;

        public Info(int v, int cost, int stops) {
            this.v = v;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public static void createGraph(int flights[][], ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }

    }

    public static int cheapestFlight(ArrayList<Edge> graph[], int src, int dest, int k) {
        int dist[] = new int[graph.length];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();

        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr.stops > k) {
                break;
            }

            for (int i = 0; i < graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);
                int v = e.dest;
                int wt = e.wt;
                if (curr.cost + wt < dist[v] && curr.stops <= k) {
                    dist[v] = curr.cost + wt;
                }
                q.add(new Info(v, dist[v], curr.stops + 1));
            }

        }
        if (dist[dest] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dist[dest];
        }

    }

    public static void main(String args[]) {
        int flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 1, 3, 600 }, { 2, 0, 100
        }, { 2, 3, 200 } };
        int n = 4;
        int src = 0;
        int dest = 3;
        int k = 1; // max possible stops

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flights, graph);

        int ans = cheapestFlight(graph, src, dest, k);
        System.out.print(ans);
    }
}
