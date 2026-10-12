package Graph;

import java.util.ArrayList;

public class CycleDetectionInDirectedGraph {
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

        // graph[0].add(new Edge(0, 2, 1));

        // graph[1].add(new Edge(1, 0, 1));

        // graph[2].add(new Edge(2, 3, 1));

        // graph[3].add(new Edge(3, 0, 1));

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 3, 1));
    }

    public static boolean isCycle(ArrayList<Edge> graph[]) { // TC O(V+E)
        boolean visited[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (isCycleUtil(graph, visited, stack, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge> graph[], boolean visited[], boolean stack[], int curr) {
        visited[curr] = true;
        stack[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (stack[e.dest] == true) {
                return true;
            }
            if (visited[e.dest] == false) {
                if (isCycleUtil(graph, visited, stack, e.dest)) {
                    return true;
                }
            }
        }
        stack[curr] = false;
        return false;
    }

    public static void main(String args[]) {
        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.print(isCycle(graph));
    }
}
