package Graph;

import java.util.ArrayList;
import java.util.Collections;

public class KruskalsAlgo {
    public static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

        public int compareTo(Edge e2) {
            return this.wt - e2.wt;
        }
    }

    public static void createGraph(ArrayList<Edge> edges) {
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 2, 40));
        edges.add(new Edge(2, 3, 50));
    }

    static int V = 4; // V -> Vertices
    static int par[] = new int[V];
    static int rank[] = new int[V];

    public static void init() {
        for (int i = 0; i < par.length; i++) {
            par[i] = i;
        }

        for (int i = 0; i < rank.length; i++) {
            rank[i] = 0;
        }
    }

    public static int find(int x) {
        if (x == par[x]) {
            return x;
        }
        return find(par[x]);
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

    public static int findMinCost(ArrayList<Edge> edges) { // TC O(V + ElogE)
        int totalCost = 0;
        int count = 0;
        Collections.sort(edges); // O(ElogE)
        for (int i = 0; count < V - 1; i++) { // O(V)
            Edge e = edges.get(i);
            int parA = find(e.src);
            int parB = find(e.dest);
            if (parA != parB) {
                union(e.src, e.dest);
                totalCost += e.wt;
                count++;
            }
        }
        return totalCost;
    }

    public static void main(String args[]) {
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);
        init();
        int ans = findMinCost(edges);
        System.out.println(ans);
    }
}
