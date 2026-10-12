package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajusAlgo {
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

        graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 3, 1));

        graph[1].add(new Edge(1, 0, 1));

        graph[2].add(new Edge(2, 1, 1));

        graph[3].add(new Edge(3, 4, 1));

    }

    public static void topSort(ArrayList<Edge> graph[], int curr, boolean visited[], Stack<Integer> s) {
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                topSort(graph, e.dest, visited, s);
            }
        }
        s.push(curr);
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean visited[]) {
        visited[curr] = true;
        System.out.print(curr + " ");
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                dfs(graph, e.dest, visited);
            }
        }
    }

    public static void kosarajuAlgo(ArrayList<Edge> graph[], int V) { // TC O(V+E)
        // step 1 :- Topological sort -> O(V+E)

        Stack<Integer> s = new Stack<>();
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topSort(graph, i, visited, s);
            }
        }

        // step 2 :- transpose graph -> O(V+E)

        @SuppressWarnings("unchecked")
        ArrayList<Edge> transpose[] = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            transpose[i] = new ArrayList<>();
            visited[i] = false;
        }
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src, e.wt));
            }
        }

        // step 3 :- perform DFS on transpose graph -> O(V+E)

        while (!s.isEmpty()) {
            int curr = s.pop();
            if (!visited[curr]) {
                System.out.print("Strongly Connected Componenet :- ");
                dfs(transpose, curr, visited);
                System.out.println();
            }
        }
    }

    public static void main(String args[]) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        kosarajuAlgo(graph, V);
    }
}
