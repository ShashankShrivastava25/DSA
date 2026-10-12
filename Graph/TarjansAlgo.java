package Graph;

import java.util.ArrayList;

public class TarjansAlgo {
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

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 3, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 1, 1));

        graph[3].add(new Edge(3, 0, 1));
        graph[3].add(new Edge(3, 4, 1));

        graph[4].add(new Edge(4, 3, 1));

    }

    public static void dfs(ArrayList<Edge> graph[], int curr, int par, int dt[], int low[], boolean vis[], int time) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;
            if (neigh == par) {
                continue;
            } else if (!vis[neigh]) {
                dfs(graph, neigh, curr, dt, low, vis, time);
                low[curr] = Math.min(low[curr], low[neigh]);
                if (dt[curr] < low[neigh]) {
                    System.out.println("Bridge : " + curr + " ---> " + neigh);
                }
            } else {
                low[curr] = Math.min(low[curr], dt[neigh]);
            }
        }
    }

    public static void tarjanBridge(ArrayList<Edge> graph[], int V) { // TC O(V+E)
        int dt[] = new int[V];
        int low[] = new int[V];
        boolean vis[] = new boolean[V];
        int time = 0;
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(graph, i, -1, dt, low, vis, time);
            }
        }
    }

    public static void main(String args[]) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        tarjanBridge(graph, V);
    }
}
